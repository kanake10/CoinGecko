package com.example.geckocoin.presentation.screens.exchanges

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.geckocoin.domain.models.Exchanges
import com.example.geckocoin.presentation.navigation.NavItem
import com.example.geckocoin.ui.theme.GeckoCoinTheme
import retrofit2.Response.error

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExchangesScreen(
    navController: NavController,
    viewModel: ExchangesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if (state.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = state.error.toString(), modifier = Modifier.align(Alignment.Center))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {
                    Text(
                        color = Color.Black,
                        text = "Exchanges"
                    )
                }
            )
        }
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            state.exchanges?.let {
                items(state.exchanges!!) { exchanges ->
                    ExchangesScreenItem(
                        exchanges = exchanges,
                        onItemClick = {
                            navController.navigate(NavItem.ExchangesDetails.route + "/${exchanges.id}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ExchangesScreenItem(exchanges: Exchanges,
                        onItemClick: (Exchanges) -> Unit) {

    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable { onItemClick(exchanges) },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .width(190.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(190.dp),
                painter = rememberImagePainter(data = exchanges.image.replace("small", "large")),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(text = exchanges.name)

            //      Divider()

        }
    }
}
