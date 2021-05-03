package com.rahil.test3.api

import com.rahil.test3.data.NewsAPI
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "cd3ebe8022124914b3d10d42528ad030"

interface newsInterface{

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHighlight(@Query("country") country:String, @Query("page")page:Int):Call<NewsAPI>
}

//builder
object newsService{
    val newsInstanciate:newsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstanciate = retrofit.create(newsInterface::class.java)
    }
}