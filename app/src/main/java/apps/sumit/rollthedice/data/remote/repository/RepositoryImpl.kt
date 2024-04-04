package apps.sumit.rollthedice.data.remote.repository

import apps.sumit.rollthedice.data.remote.DiceAPI
import apps.sumit.rollthedice.data.remote.dto.DetailsDTO
import apps.sumit.rollthedice.data.remote.dto.DiceDTO
import apps.sumit.rollthedice.domain.repository.Repository

class RepositoryImpl(private val api: DiceAPI) : Repository {
    override suspend fun getDetails(): DetailsDTO {
        return api.getDetails()
    }

    override suspend fun getDice(): DiceDTO {
        return api.getDice()
    }
}