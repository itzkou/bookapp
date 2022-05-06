package com.example.bfn.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bfn.databinding.ItemRecentBookBinding
import com.example.bfn.models.Books
import com.example.bfn.util.SimpleCallback


class RecentlyReadBooksAdapter : RecyclerView.Adapter<RecentlyReadBooksAdapter.ViewHolder>() {

    private var books = listOf<Books>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return RecentlyReadBooksAdapter.ViewHolder(
            ItemRecentBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trip = books[position]
        with(holder.binding) {

        }

    }


    override fun getItemCount(): Int {
        return books.size
    }


    fun updateBooks(newBooks: List<Books>) {
        val diffResult =
            DiffUtil.calculateDiff(SimpleCallback(this.books, newBooks) { it.id!! })
        this.books = newBooks
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(val binding: ItemRecentBookBinding) : RecyclerView.ViewHolder(binding.root)
}

