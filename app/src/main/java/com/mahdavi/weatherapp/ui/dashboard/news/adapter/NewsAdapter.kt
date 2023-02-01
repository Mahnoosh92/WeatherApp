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
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ArticleViewHolder).bind(data[position])
    }

    inner class ArticleViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article) {
            binding.apply {

                articleText.text = article.author
            }
        }
    }
}

//class PersonDiffUtil : DiffUtil.ItemCallback<Article>() {
//    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
//        return oldItem.id == newItem.id
//    }
//
//    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
//        return oldItem == newItem
//    }
//}