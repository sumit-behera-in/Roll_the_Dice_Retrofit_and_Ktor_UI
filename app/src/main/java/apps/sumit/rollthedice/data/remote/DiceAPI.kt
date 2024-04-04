package apps.sumit.rollthedice.data.remote

import apps.sumit.rollthedice.data.remote.dto.DetailsDTO
import apps.sumit.rollthedice.data.remote.dto.DiceDTO
import retrofit2.http.GET

interface DiceAPI {
    @GET()
    suspend fun getDetails(): DetailsDTO

    @GET("/random")
    suspend fun getDice(): DiceDTO

}