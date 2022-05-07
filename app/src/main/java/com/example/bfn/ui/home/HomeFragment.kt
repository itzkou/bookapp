package com.example.bfn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bfn.Adapters.BooksAdapter
import com.example.bfn.Adapters.RecentlyReadBooksAdapter
import com.example.bfn.databinding.FragmentHomeBinding
import com.example.bfn.models.Book

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupUi()

        return binding.root
    }


    private fun setupUi() {
        val recentlyReadBooksAdapter = RecentlyReadBooksAdapter()
        val readBooksAdapter = BooksAdapter()


        binding.rvRecent.apply {
            adapter = recentlyReadBooksAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        }
        binding.rvBooks.apply {
            adapter = readBooksAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }

        readBooksAdapter.updateBooks(listOf<Book>(Book("1"),Book("2"),Book("2"),Book("2"),Book("2")))
        recentlyReadBooksAdapter.updateBooks(listOf<Book>(Book("1"),Book("2"),Book("2"),Book("2"),Book("2")))

    }
}