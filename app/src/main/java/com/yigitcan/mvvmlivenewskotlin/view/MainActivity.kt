package com.yigitcan.mvvmlivenewskotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yigitcan.mvvmlivenewskotlin.adapter.NewsAdapter
import com.yigitcan.mvvmlivenewskotlin.databinding.ActivityMainBinding
import com.yigitcan.mvvmlivenewskotlin.model.News
import com.yigitcan.mvvmlivenewskotlin.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var context: AppCompatActivity
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
        setContentView(binding.root)
        newsViewModel = ViewModelProvider(context).get(NewsViewModel::class.java)
        newsViewModel.userMutableLiveData.observe(context, userListUpdateObserver)
    }

    private var userListUpdateObserver: Observer<ArrayList<News>?> =
        Observer<ArrayList<News>?> { newsArrayList ->
            newsAdapter = NewsAdapter(newsArrayList, context)
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = newsAdapter
        }
}




