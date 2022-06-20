package com.example.geckocoin.domain.usecases


import com.example.geckocoin.core.Resource
import com.example.geckocoin.data.mappers.toExchangesDetails
import com.example.geckocoin.domain.models.ExchangesDetails
import com.example.geckocoin.domain.repository.ExchangesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetSingleExchangeUseCase @Inject constructor(
    private val repository: ExchangesRepository
) {
    operator fun invoke(exchangesId: String): Flow<Resource<ExchangesDetails>> = flow {
        try {
            emit(Resource.Loading<ExchangesDetails>())
            val exchange = repository.getExchangesDetails(exchangesId).toExchangesDetails()
            emit(Resource.Success<ExchangesDetails>(exchange))
        } catch(e: HttpException) {
            emit(Resource.Error<ExchangesDetails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<ExchangesDetails>("Couldn't reach server. Check your internet connection."))
        }
    }
}