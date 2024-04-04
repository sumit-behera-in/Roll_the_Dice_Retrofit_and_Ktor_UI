package apps.sumit.rollthedice.domain.repository

import apps.sumit.rollthedice.data.remote.dto.DetailsDTO
import apps.sumit.rollthedice.data.remote.dto.DiceDTO

interface Repository {

    suspend fun getDetails(): DetailsDTO

    suspend fun getDice(): DiceDTO
    
}