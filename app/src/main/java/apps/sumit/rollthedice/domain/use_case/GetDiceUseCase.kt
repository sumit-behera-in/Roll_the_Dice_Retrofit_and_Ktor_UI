package apps.sumit.rollthedice.domain.use_case

import apps.sumit.rollthedice.common.Resource
import apps.sumit.rollthedice.data.remote.dto.toDice
import apps.sumit.rollthedice.domain.model.Dice
import apps.sumit.rollthedice.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDiceUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<Resource<Dice>> = flow {
        try {

            emit(Resource.Loading<Dice>())
            val coin = repository.getDice().toDice()
            emit(Resource.Success<Dice>(coin))

        } catch (e: HttpException) {
            // unsuccessful api call
            emit(Resource.Error<Dice>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            // io error
            emit(Resource.Error<Dice>(e.localizedMessage ?: "No Internet Connection"))
        }
    }
}