package com.example.bfn.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bfn.Adapters.BooksAdapter
import com.example.bfn.Adapters.RecentlyReadBooksAdapter
import com.example.bfn.databinding.FragmentHomeBinding
import com.example.bfn.models.BooksResponse
import com.example.bfn.models.GetUserResponse
import com.example.bfn.models.Token
import com.example.bfn.models.UserX
import com.example.bfn.prefs.PrefsManager
import com.example.bfn.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val apiservice = ApiClient.apiService
    private val readBooksAdapter = BooksAdapter()
    private val recentlyReadBooksAdapter = RecentlyReadBooksAdapter()


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllBooks()
        getUser()
    }


    private fun setupUi() {


        binding.rvRecent.apply {
            adapter = recentlyReadBooksAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, true)
        }
        binding.rvBooks.apply {
            adapter = readBooksAdapter
            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        }


    }

    private fun getAllBooks() {

        apiservice.getAllBooks().enqueue(object : Callback<BooksResponse> {
            override fun onResponse(
                call: Call<BooksResponse>,
                response: Response<BooksResponse>
            ) {
                if (response.isSuccessful) {
                    readBooksAdapter.updateBooks(response.body().response)
                    recentlyReadBooksAdapter.updateBooks(
                        response.body().response
                    )

                }
            }

            override fun onFailure(call: Call<BooksResponse>?, t: Throwable?) {
                Toast.makeText(requireActivity(), "Network faillure", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun getUser() {
        val token = PrefsManager.geToken(requireActivity())
         token?.let {
            apiservice.getUserById(UserX(token)).enqueue(object : Callback<GetUserResponse> {
                override fun onResponse(
                    call: Call<GetUserResponse>?,
                    response: Response<GetUserResponse>
                ) {
                    if (response.isSuccessful){
                        binding.tvUsername.text = "Hi " + response.body().dataid.firstName +" !"
                    }
                }

                override fun onFailure(call: Call<GetUserResponse>?, t: Throwable?) {
                    Toast.makeText(requireActivity(), "Network Faillure", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }

}