package com.brs.codechallenge.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.brs.codechallenge.R
import com.brs.codechallenge.middleware.GoogleBooksService
import com.brs.codechallenge.model.api.GoogleBooksResponseModel
import com.brs.codechallenge.view.adapters.SearchResultsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchBooksVM : BaseVM() {
    @Inject
    lateinit var googleBooksApiService: GoogleBooksService
    private lateinit var subscription: Disposable
    private lateinit var searchWord: String
    val searchResultsAdapter: SearchResultsAdapter = SearchResultsAdapter()
    val loaderVisibility: MutableLiveData<Int> = MutableLiveData()
    val instructionVisibility: MutableLiveData<Int> = MutableLiveData()
    val resultsVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { searchBooks(searchWord) }

    fun searchBooks(searchWord: String) {
        this.searchWord = searchWord
        subscription = googleBooksApiService.getGoogleBooksAPI(searchWord)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {showLoader(true)}
            .doOnTerminate {showLoader(false)}
            .subscribe(
                {result -> showResult(result)},
                {showError()}
            )
    }

    override fun onCleared() {
        super.onCleared()
        searchWord = ""
        subscription.dispose()
    }
    private fun showLoader(isLoading: Boolean) {
        resultsVisibility.value = View.GONE
        loaderVisibility.value = if (isLoading) View.VISIBLE else View.GONE
        instructionVisibility.value = View.GONE
    }
    private fun showResult(response: GoogleBooksResponseModel) {
        resultsVisibility.value = View.VISIBLE
        searchResultsAdapter.updateBookList(response.volumeList)
    }

    private fun showError() {
        errorMessage.value = R.string.retrieve_error
    }
}