package com.example.geckocoin.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.geckocoin.domain.models.Exchanges

@Composable
fun HomeScreen(navController: NavController, viewModel: ExchangesViewModel = hiltViewModel()) {

    val res = viewModel.state.value

    if (res.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (res.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = res.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }

    LazyColumn {
        res.data?.let {
            items(it) {
                ExchangesScreen(it)
            }

        }

    }


}

@Composable
fun ExchangesScreen(it: Exchanges) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.width(6.dp))


        Image(
            modifier = Modifier
                .width(190.dp)
                .clip(RoundedCornerShape(10.dp))
                .height(190.dp),
            painter = rememberImagePainter(data = it.image.replace("small","large")),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Divider()

    }

}
