package com.brs.codechallenge.model.api

import com.google.gson.annotations.SerializedName

data class BookInfoModel (
    @SerializedName("title")
    val bookTitle: String?,
    @SerializedName("authors")
    val bookAuthors: List<String>?,
    @SerializedName("imageLinks")
    val images: ImageLinksModel?,
    @SerializedName("description")
    val information: String?
)