package com.example.trabajo4y5.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.trabajo4y5.component.NewsCard
import com.example.trabajo4y5.component.topBar
import com.example.trabajo4y5.viewModel.NewsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, viewModel: NewsViewModel = hiltViewModel()) {
    Scaffold(
        topBar = { topBar("News", navController) },
        content = { ContentHomeView(it, navController, viewModel) },
        bottomBar = {}
    )
}
@Composable
fun ContentHomeView(
    paddingValues: PaddingValues,
    navController: NavController,
    viewModel: NewsViewModel
) {

    val state = viewModel.state

    Column(
        modifier = androidx.compose.ui.Modifier.padding(paddingValues)
    ) {
        LazyColumn(
            modifier = androidx.compose.ui.Modifier.padding(6.dp)
        ) {
            items(state.news) {
                NewsCard(navController, it, viewModel)
            }
        }
    }
}