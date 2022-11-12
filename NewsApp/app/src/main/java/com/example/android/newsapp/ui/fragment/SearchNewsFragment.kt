package com.example.android.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.newsapp.ui.MainActivity
import com.example.android.newsapp.R
import com.example.android.newsapp.adapter.NewsAdapter
import com.example.android.newsapp.ui.NewsViewModel
import com.example.android.newsapp.util.Contants.Companion.SEARCH_NEWS_TIME_DELAY
import com.example.android.newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*
import kotlinx.android.synthetic.main.fragment_breaking_news.paginationProgressBar
import kotlinx.android.synthetic.main.fragment_search_news.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchNewsFragment : Fragment(R.layout.fragment_search_news) {
    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        var job: Job? = null
        etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_NEWS_TIME_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchNews(editable.toString())
                    }
                }
            }
        }

        viewModel.searchNews.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProcessBar()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProcessBar()
                }
                is Resource.Loading -> showProcessBar()
            }
        })
    }

    private fun hideProcessBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProcessBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setUpRecylerView() {
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
