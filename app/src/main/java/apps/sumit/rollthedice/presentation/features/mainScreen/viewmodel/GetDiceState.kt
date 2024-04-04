package apps.sumit.rollthedice.presentation.features.mainScreen.viewmodel

import apps.sumit.rollthedice.domain.model.Details
import apps.sumit.rollthedice.domain.model.Dice

data class GetDiceState(
    val isLoading: Boolean = false,
    val error: String = "",
    val details: Details? = null,
    val dice: Dice? = null,
)