package com.brs.codechallenge.middleware

import com.brs.codechallenge.constants.Constants
import com.brs.codechallenge.model.api.GoogleBooksResponseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksService {
    @GET(Constants.BASE_URL + Constants.ENDPOINT)
    fun getGoogleBooksAPI(@Query("q") q: String,
                          @Query("key") key: String = Constants.API_KEY):
            Observable<GoogleBooksResponseModel>

    companion object {
        fun create(): GoogleBooksService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(GoogleBooksService::class.java)
        }
    }
}

