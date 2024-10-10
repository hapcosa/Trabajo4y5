package com.example.trabajo4y5.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


data class ApiResponse(
    var totalResults:Int,
    var articles: List<Article>
)

data class Article(
    var id:Int=0,
    var source: Source= Source("",""),
    var nombre: String? = "",
    var author: String? = "",
    var title: String? = "",
    var description: String? = "",
    var url: String? = "",
    var urlToImage: String? = "",
)

data class Source(
    var id: String,
    var name: String
)