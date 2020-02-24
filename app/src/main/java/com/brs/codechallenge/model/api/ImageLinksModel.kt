package com.brs.codechallenge.model.api

import com.google.gson.annotations.SerializedName

data class ImageLinksModel (
    @SerializedName("thumbnail")
    val thumbnailLink: String?
)