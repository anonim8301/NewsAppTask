package com.example.newsapptask.presentation.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.newsapptask.R
import com.example.newsapptask.presentation.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(R.layout.fragment_category) {

    private val viewModel: NewsViewModel by viewModels()
}