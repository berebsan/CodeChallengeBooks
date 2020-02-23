package com.brs.codechallenge.model.api

import com.google.gson.annotations.SerializedName

class VolumeModel (
    @SerializedName("kind")
    val kindVolume: String?,
    @SerializedName("volumeInfo")
    val bookInfo: List<BookInfoModel>
)