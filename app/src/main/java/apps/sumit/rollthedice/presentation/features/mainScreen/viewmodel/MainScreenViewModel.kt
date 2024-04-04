package apps.sumit.rollthedice.presentation.features.mainScreen.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import apps.sumit.rollthedice.common.Resource
import apps.sumit.rollthedice.domain.model.Details
import apps.sumit.rollthedice.domain.model.Dice
import apps.sumit.rollthedice.domain.use_case.GetDetailsUseCase
import apps.sumit.rollthedice.domain.use_case.GetDiceUseCase
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val getDiceUseCase: GetDiceUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(GetDiceState())
    val state = _state

    init {
        getDetails()
    }

    private fun getDetails() {
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
        }
    }

    fun getDice() {
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
        }
    }
}