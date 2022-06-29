package com.yigitcan.mvvmlivenewskotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yigitcan.mvvmlivenewskotlin.R
import com.yigitcan.mvvmlivenewskotlin.model.News
import com.yigitcan.mvvmlivenewskotlin.view.WebActivity


class NewsAdapter(private val newsList: ArrayList<News>, private var mContext: AppCompatActivity): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_list,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]

            holder.cardView.setOnClickListener{
                mContext.startActivity(Intent(mContext, WebActivity::class.java).putExtra("url",currentItem.url))
            }

        Picasso.with(mContext).load(currentItem.urlToImage).into(holder.imageView)
        holder.txtTitle.setText(currentItem.title)
        holder.txtDescription.setText(currentItem.description)

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
    }

}