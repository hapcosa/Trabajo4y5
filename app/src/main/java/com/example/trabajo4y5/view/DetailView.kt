package com.example.trabajo4y5.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.trabajo4y5.component.topBar
import com.example.trabajo4y5.viewModel.NewsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, viewModel: NewsViewModel, id: Int) {

    Scaffold(
        topBar = { topBar("Inicio", navController) },
        content = { ContentDetailView(it, navController, viewModel, id) },
        )
}

@Composable
fun ContentDetailView(
    it: PaddingValues,
    navController: NavController,
    viewModel: NewsViewModel,
    id: Int
) {
    LaunchedEffect(Unit) {
        viewModel.getNews(id)
    }
    val article = viewModel.state.article

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(article.urlToImage),
            contentDescription = article.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        article.author?.let { Text("Author: $it", style = MaterialTheme.typography.bodyMedium) }
        article.title?.let { Text("Title: $it", style = MaterialTheme.typography.bodyLarge) }
        article.description?.let {
            Text(
                "Description: $it",
                style = MaterialTheme.typography.bodySmall
            )
        }

        article.url?.let { url ->
            Text("Leer mas",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.clickable{
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                })
        }
    }
}



