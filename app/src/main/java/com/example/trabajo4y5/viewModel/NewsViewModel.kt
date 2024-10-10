package com.example.trabajo4y5.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.trabajo4y5.repository.NewsRepository
import com.example.trabajo4y5.state.newsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val Repo: NewsRepository
) : ViewModel() {

    var state by mutableStateOf(newsState())
        private set

    init {
        viewModelScope.launch {
            val news = Repo.getAllNews()
            state = state.copy(
                news = news
            )

        }

    }
    fun getNews(id: Int) {
        viewModelScope.launch {
            state.article=Repo.getNews(id)
        }

    }
}