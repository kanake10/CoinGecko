package com.example.geckocoin.presentation.screens.details

import com.example.geckocoin.domain.usecases.GetSingleExchangeUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geckocoin.core.Constants
import com.example.geckocoin.core.Resource

@HiltViewModel
class ExchangesDetailsViewModel @Inject constructor(
    private val getSingleExchangeUseCase: GetSingleExchangeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    val details = mutableStateOf(ExchangeDetailsState())

    init {
        savedStateHandle.getLiveData<String>("blogId").value?.let {
            getBlogDetails(it)
        }
    }

    fun getBlogDetails(exchangesId: String) {
        getSingleExchangeUseCase(exchangesId).onEach {
            when (it) {
                is Resource.Loading -> {
                    details.value = ExchangeDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    details.value = ExchangeDetailsState(data = it.data)
                }
                is Resource.Error -> {
                    details.value = ExchangeDetailsState(error = it.message.toString())
                }
            }


        }.launchIn(viewModelScope)
    }


}