package com.yigitcan.mvvmlivenewskotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.yigitcan.mvvmlivenewskotlin.databinding.ActivityWebBinding


class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        // call and load url
        intent.getStringExtra("url")?.let { binding.webView.loadUrl(it) }
    }
}