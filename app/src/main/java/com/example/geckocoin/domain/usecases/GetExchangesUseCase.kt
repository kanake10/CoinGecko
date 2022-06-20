package com.example.geckocoin.domain.usecases


import com.example.geckocoin.core.Resource
import com.example.geckocoin.data.mappers.toExchanges
import com.example.geckocoin.domain.models.Exchanges
import com.example.geckocoin.domain.repository.ExchangesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExchangesUseCase @Inject constructor(
    private val repository: ExchangesRepository
) {
    operator fun invoke(): Flow<Resource<List<Exchanges>>> = flow {
        try {
            emit(Resource.Loading<List<Exchanges>>())
            val exchanges = repository.getExchanges().map { it.toExchanges() }
            emit(Resource.Success<List<Exchanges>>(exchanges))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Exchanges>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Exchanges>>("Couldn't reach server. Check your internet connection."))
        }
    }
}