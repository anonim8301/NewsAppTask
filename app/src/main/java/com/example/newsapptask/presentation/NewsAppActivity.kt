package com.example.newsapptask.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapptask.R
import com.example.newsapptask.databinding.ActivityNewsappBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsAppActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsappBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = findNavController(R.id.newsAppNavHostFragment)
        binding.bottomNavigationView.setupWithNavController(navHostFragment)
    }
}