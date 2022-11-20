package com.example.android.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.android.newsapp.R
import com.example.android.newsapp.ui.MainActivity
import com.example.android.newsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_show_news.*

class ShowNewsFragment : Fragment(R.layout.fragment_show_news) {

    lateinit var viewModel: NewsViewModel
    val args : BreakingNewsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }
    }
}