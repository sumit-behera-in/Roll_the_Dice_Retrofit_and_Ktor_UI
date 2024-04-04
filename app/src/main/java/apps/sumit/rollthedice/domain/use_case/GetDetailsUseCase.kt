package apps.sumit.rollthedice.domain.use_case

import apps.sumit.rollthedice.common.Resource
import apps.sumit.rollthedice.data.remote.dto.toDetails
import apps.sumit.rollthedice.domain.model.Details
import apps.sumit.rollthedice.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<Resource<Details>> = flow {
        try {

            emit(Resource.Loading<Details>())
            val coin = repository.getDetails().toDetails()
            emit(Resource.Success<Details>(coin))

        } catch (e: HttpException) {
            // unsuccessful api call
            emit(Resource.Error<Details>(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException) {
            // io error
            emit(Resource.Error<Details>(e.localizedMessage ?: "No Internet Connection"))
        }
    }
}