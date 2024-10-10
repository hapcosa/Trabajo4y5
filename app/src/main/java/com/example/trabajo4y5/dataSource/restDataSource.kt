package com.example.trabajo4y5.viewModel




import com.example.trabajo4y5.models.ApiResponse
import com.example.trabajo4y5.utils.constants.Companion.APY_KEY
import com.example.trabajo4y5.utils.constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface restDataSource {
    @GET(ENDPOINT+ APY_KEY)
    suspend fun getNews(): Response<ApiResponse>
}