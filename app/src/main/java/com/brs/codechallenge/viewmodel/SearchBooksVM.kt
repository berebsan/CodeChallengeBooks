package com.brs.codechallenge.viewmodel

import com.brs.codechallenge.middleware.GoogleBooksService
import com.brs.codechallenge.model.api.VolumeModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchBooksVM {
    private val googleBooksApiService by lazy {
        GoogleBooksService.create()
    }
    private lateinit var subscription: Disposable

    fun searchBooks(searchWord: String) {
        subscription = googleBooksApiService.getGoogleBooksAPI(searchWord)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {showLoader(true)}
            .doOnTerminate {showLoader(false)}
            .subscribe(
                {result -> showResult(result.totalItems, result.volumeList)},
                {showError(it.message)}
            )
    }

    private fun showLoader(isLoading: Boolean) {

    }
    private fun showResult(totalItems: Int, volumeList: List<VolumeModel>) {

    }

    private fun showError(message: String?) {

    }
}