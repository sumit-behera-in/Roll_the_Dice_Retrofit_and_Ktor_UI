package apps.sumit.rollthedice.presentation.features.mainScreen.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import apps.sumit.rollthedice.common.Resource
import apps.sumit.rollthedice.domain.model.Details
import apps.sumit.rollthedice.domain.model.Dice
import apps.sumit.rollthedice.domain.use_case.GetDetailsUseCase
import apps.sumit.rollthedice.domain.use_case.GetDiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val getDiceUseCase: GetDiceUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(GetDiceState())
    val state = _state

    init {
        getDetails()
        getDice()
    }

    private fun getDetails() {
        Log.d("api", " getDetails view model")
        getDetailsUseCase().onEach { resource: Resource<Details> ->
            when (resource) {
                is Resource.Error -> {
                    _state.value = GetDiceState(error = resource.message ?: "Unknown error")
                }

                is Resource.Loading -> {
                    _state.value = GetDiceState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = GetDiceState(details = resource.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getDice() {
        Log.d("api", " getDice view model")
        getDiceUseCase().onEach { resource: Resource<Dice> ->
            when (resource) {
                is Resource.Error -> {
                    _state.value = GetDiceState(error = resource.message ?: "Unknown error")
                }

                is Resource.Loading -> {
                    _state.value = GetDiceState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = GetDiceState(dice = resource.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}