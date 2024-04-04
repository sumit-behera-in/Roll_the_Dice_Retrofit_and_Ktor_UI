package apps.sumit.rollthedice.data.remote.dto

import apps.sumit.rollthedice.domain.model.Details

data class DetailsDTO(
    val email: String,
    val github: String,
    val linkedIn: String,
    val mobile: String,
    val name: String,
)

fun DetailsDTO.toDetails(): Details {
    return Details(
        email, github, linkedIn, mobile, name
    )
}