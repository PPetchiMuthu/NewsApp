package com.example.android.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.newsapp.R
import com.example.android.newsapp.adapter.NewsAdapter
import com.example.android.newsapp.ui.MainActivity
import com.example.android.newsapp.ui.NewsViewModel
import com.example.android.newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breaking_news.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breaking_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecylerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article",it)
            }
            findNavController().navigate(R.id.action_breakingNewsFragment_to_showNewsFragment,
            bundle)
        }

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
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