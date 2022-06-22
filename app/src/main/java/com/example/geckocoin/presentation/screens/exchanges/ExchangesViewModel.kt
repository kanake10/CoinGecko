package com.example.geckocoin.presentation.screens.exchanges

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geckocoin.core.Resource
import com.example.geckocoin.domain.usecases.GetExchangesUseCase

@HiltViewModel
class ExchangesViewModel @Inject constructor(
    private val getExchangesUseCase: GetExchangesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ExchangesState())
    val state: State<ExchangesState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getExchangesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ExchangesState(exchanges = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ExchangesState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ExchangesState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}