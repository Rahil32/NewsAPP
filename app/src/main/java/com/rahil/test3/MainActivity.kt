package com.rahil.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rahil.test3.adapter.Adapter
import com.rahil.test3.api.newsService
import com.rahil.test3.data.NewsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter:Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews(){
        val newsApi = newsService.newsInstanciate.getHighlight("in",1)
        newsApi.enqueue(object:Callback<NewsAPI>{
            override fun onResponse(call: Call<NewsAPI>, response: Response<NewsAPI>) {
                val newsApi = response.body()
                if (newsApi != null){
                    Log.d("Sumanta",newsApi.toString())
                    adapter = Adapter(this@MainActivity,newsApi.articles)

                    val recyclerList = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerList.adapter = adapter
                    recyclerList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<NewsAPI>, t: Throwable) {
                Log.d("Sumanta", "Not found",t)
            }
        })
    }
}