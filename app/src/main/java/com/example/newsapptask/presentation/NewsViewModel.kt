package com.example.newsapptask.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapptask.model.NewsResponse
import com.example.newsapptask.other.Resource
import com.example.newsapptask.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    val topNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var topNewsPage = 1
    var topNewsResponse: NewsResponse? = null

    init {
        getTopNews("us")
    }

    fun getTopNews(countryCode: String) = viewModelScope.launch {
        topNews.postValue(Resource.Loading())
        val response = repository.getTopNews(countryCode, topNewsPage)
        topNews.postValue(handleTopNewsResponse(response))
    }

    private fun handleTopNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { respondResult ->
                topNewsPage++
                if (topNewsResponse == null) {
                    topNewsResponse = respondResult
                } else {
                    val oldArticles = topNewsResponse?.articles
                    val newArticles = respondResult.articles
                    oldArticles?.addAll(newArticles)
                }
                return Resource.Success(topNewsResponse ?: respondResult)
            }
        }
        return Resource.Error(response.message())
    }
}