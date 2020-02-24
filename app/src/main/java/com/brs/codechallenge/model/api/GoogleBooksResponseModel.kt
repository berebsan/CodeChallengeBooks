package com.brs.codechallenge.model.api

import com.google.gson.annotations.SerializedName

data class GoogleBooksResponseModel(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("items")
    val volumeList: List<VolumeModel>
)