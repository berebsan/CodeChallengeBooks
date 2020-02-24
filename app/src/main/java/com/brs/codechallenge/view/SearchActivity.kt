package com.brs.codechallenge.view

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.brs.codechallenge.R
import com.brs.codechallenge.viewmodel.SearchBooksVM
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchBooksVM = SearchBooksVM()

        searchBox.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchBooksVM.searchBooks(searchBox.query.toString())

                val bookResultsFragment = BookResultsFragment.newInstance()
                supportFragmentManager.inTransaction {
                    add(R.id.frameLayout, bookResultsFragment)
                }
                return false
            }

        })
    }
}

private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}
