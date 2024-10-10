package com.example.trabajo4y5.state

import com.example.trabajo4y5.models.Article


data class newsState(val news: List<Article> =emptyList(), var article: Article=Article())

