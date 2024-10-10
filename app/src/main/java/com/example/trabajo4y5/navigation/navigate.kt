package com.example.trabajo4y5.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.trabajo4y5.view.DetailView
import com.example.trabajo4y5.view.HomeView
import com.example.trabajo4y5.viewModel.NewsViewModel

@Composable
fun NavManager(viewModel: NewsViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController, viewModel)
        }
        composable(
            "DetailView/{id}", arguments = listOf(
                navArgument("id") { type = NavType.IntType })

        ) {
            val id = it.arguments!!.getInt("id")
            DetailView(navController, viewModel, id)
        }
    }
}