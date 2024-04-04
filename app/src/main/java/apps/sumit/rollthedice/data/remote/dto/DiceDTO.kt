package apps.sumit.rollthedice.data.remote.dto

import apps.sumit.rollthedice.domain.model.Dice

data class DiceDTO(
    val description: String,
    val imageUrl: String,
    val name: String,
)

fun DiceDTO.toDice(): Dice {
    return Dice(
        description, imageUrl, name
    )
}