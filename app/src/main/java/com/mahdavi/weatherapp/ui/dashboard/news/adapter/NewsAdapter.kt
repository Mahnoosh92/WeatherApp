package com.mahdavi.weatherapp.ui.dashboard.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdavi.weatherapp.data.model.local.news.Article
import com.mahdavi.weatherapp.databinding.NewsItemBinding

class NewsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data: MutableList<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    fun addItems(items: List<Article>) {
        val size = this.data.size
        this.data.addAll(items)
        val sizeNew = this.data.size
        notifyItemRangeChanged(size, sizeNew)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).bind(data[position], position)
    }

    inner class ArticleViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, index: Int) {
            binding.apply {
                //articleText.text = article.author
                articleText.text = index.toString()
            }
        }
    }
}
