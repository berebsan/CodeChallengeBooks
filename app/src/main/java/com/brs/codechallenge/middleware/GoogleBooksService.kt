package com.brs.codechallenge.middleware

import com.brs.codechallenge.constants.Constants
import com.brs.codechallenge.model.api.GoogleBooksResponseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksService {
    @GET(Constants.BASE_URL + Constants.ENDPOINT)
    fun getGoogleBooksAPI(@Query("q") q: String,
                          @Query("key") key: String = Constants.API_KEY):
            Observable<GoogleBooksResponseModel>
}

