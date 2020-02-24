package com.brs.codechallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import com.brs.codechallenge.model.api.VolumeModel

class BookResultsVM: BaseVM() {
    val thumbUrl: MutableLiveData<String?> = MutableLiveData()
    val bookTitle: MutableLiveData<String?> = MutableLiveData()
    val bookAuthors: MutableLiveData<List<String?>> = MutableLiveData()
    val bookInfo: MutableLiveData<String?> = MutableLiveData()

    fun bind(volume: VolumeModel) {
        bookAuthors.value = volume.bookInfo?.bookAuthors
        bookTitle.value = volume.bookInfo?.bookTitle
        thumbUrl.value = volume.bookInfo?.images?.thumbnailLink
        bookInfo.value = volume.bookInfo?.information
    }
}