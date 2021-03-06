package com.rahil.test3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahil.test3.R
import com.rahil.test3.data.Article

class Adapter(val context:Context, val articles:List<Article>):RecyclerView.Adapter<Adapter.ArticleViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       val article = articles[position]
        holder.newsTitle.text = article.title
        holder.newsDescription.text = article.description

        Glide.with(context).load(article.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val newsImage = itemView.findViewById<ImageView>(R.id.ivArticleImage)
        val newsTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val newsDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    }
}