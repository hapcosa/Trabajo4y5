package com.example.trabajo4y5.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.trabajo4y5.models.Article
import com.example.trabajo4y5.viewModel.NewsViewModel


@Composable
fun NewsCard(navController: NavController, article: Article, viewModel: NewsViewModel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navController.navigate("DetailView/${article.id}") }
    ) {Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberImagePainter(article.urlToImage),
            contentDescription = article.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        if(article.nombre !=""){
            Text(article.nombre.toString(), style = MaterialTheme.typography.bodyMedium)
        }

        if(article.author !=""){
            Spacer(modifier = Modifier.height(4.dp))
            Text("by ${article.author.toString()}", style = MaterialTheme.typography.bodyMedium)
        }
        if(article.title !=""){
            Spacer(modifier = Modifier.height(4.dp))
            Text("by ${article.title}", style = MaterialTheme.typography.bodyMedium)
        }
    }
    }
}


