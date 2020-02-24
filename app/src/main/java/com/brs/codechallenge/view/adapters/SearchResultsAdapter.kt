package com.brs.codechallenge.view.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brs.codechallenge.model.api.VolumeModel
import android.view.LayoutInflater
import com.brs.codechallenge.R
import androidx.databinding.DataBindingUtil
import com.brs.codechallenge.databinding.ItemBookCardBinding
import com.brs.codechallenge.model.api.BookInfoModel
import com.brs.codechallenge.viewmodel.BookResultsVM

class SearchResultsAdapter : RecyclerView.Adapter<SearchResultsAdapter.BooksViewHolder>() {
    private var volumeList: List<VolumeModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val binding: ItemBookCardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_book_card,
            parent,
            false
        )
        return BooksViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return volumeList.size
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(volumeList[position])
    }

    inner class BooksViewHolder(private val binding: ItemBookCardBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = BookResultsVM()

        fun bind(book:VolumeModel){
            viewModel.bind(book)
            binding.viewModel = viewModel
        }
    }

    fun updateBookList(volumeList:List<VolumeModel>){
        this.volumeList = volumeList
        notifyDataSetChanged()
    }
}