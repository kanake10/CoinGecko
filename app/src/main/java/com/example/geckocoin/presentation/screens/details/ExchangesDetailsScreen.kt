package com.example.geckocoin.presentation.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.geckocoin.data.api.CoinGeckoApi
import com.example.geckocoin.presentation.screens.exchanges.ExchangesScreenItem
import com.example.geckocoin.presentation.screens.exchanges.ExchangesViewModel
import com.example.geckocoin.ui.theme.GeckoCoinTheme


@Composable
fun ExchangesDetailsScreen(
    viewModel: ExchangesDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()

    state.exchangesDetails?.let { exchangesDetails ->
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(12.dp)
        ) {

            Text(text = exchangesDetails.name)
            Image(
                modifier = Modifier
                    .width(190.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(190.dp),
                painter = rememberImagePainter(
                    data = exchangesDetails.image.replace(
                        "small",
                        "large"
                    )
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }



    }
}


