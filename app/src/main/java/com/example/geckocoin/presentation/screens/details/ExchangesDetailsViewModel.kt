package com.example.geckocoin.presentation.screens.details

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
import com.example.geckocoin.domain.usecases.GetSingleExchangeUseCase

@HiltViewModel
class ExchangesDetailsViewModel @Inject constructor(
    private val getSingleExchangeUseCase: GetSingleExchangeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ExchangesDetailsState())
    val state: State<ExchangesDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ID)?.let { id ->
            getExchangesDetails(id)
        }
    }

    private fun getExchangesDetails(id: String) {
        getSingleExchangeUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ExchangesDetailsState(exchangesDetails = result.data)
                }
                is Resource.Error -> {
                    _state.value = ExchangesDetailsState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ExchangesDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}