package com.example.bfn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bfn.databinding.ActivityBookDetailsBinding
import com.example.bfn.util.BlurAppBar

class BookDetails : AppCompatActivity() {
    private lateinit var binding: ActivityBookDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUi()
    }



    private  fun setupUi(){

        val blurAppBar = BlurAppBar(this)
        blurAppBar.blurAppBar(binding.appBar,binding.imEvent)
    }
}