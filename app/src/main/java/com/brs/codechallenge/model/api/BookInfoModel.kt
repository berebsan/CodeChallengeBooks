package com.brs.codechallenge.model.api

import com.google.gson.annotations.SerializedName

class BookInfoModel (
    @SerializedName("title")
    val bookTitle: String?,
    @SerializedName("authors")
    val bookAuthors: ArrayList<String>,
    @SerializedName("imageLinks")
    val images: List<ImageLinksModel>
)