package com.example.trabajo4y5.repository


import android.util.Log
import com.example.trabajo4y5.models.Article
import com.example.trabajo4y5.viewModel.restDataSource

import javax.inject.Inject

interface NewsRepository {
    suspend fun getNews(id: Int): Article
    suspend fun getAllNews(): ArrayList<Article>

}

class NewsRepositoryImp @Inject constructor(
    private val dataSource: restDataSource,

    ) : NewsRepository {
    override suspend fun getNews(id: Int): Article {

        return dataSource.getNews().body()!!.articles[id]
    }

    override suspend fun getAllNews(): ArrayList<Article> {
        val respond = dataSource.getNews()
        val listnews: ArrayList<Article> = arrayListOf()
        var news: Article
        var i:Int=0
        for (result in respond.body()!!.articles) {

            news = Article(
                i,
                result.source,
                result.nombre,
                result.author,
                result.title,
                result.description,
                result.url,
                result.urlToImage
            )
            i++
            listnews.add(news)


        }
        return listnews

    }
}