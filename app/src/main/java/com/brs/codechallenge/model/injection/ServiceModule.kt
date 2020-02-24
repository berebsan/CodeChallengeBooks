package com.brs.codechallenge.model.injection

import com.brs.codechallenge.constants.Constants.Companion.BASE_URL
import com.brs.codechallenge.middleware.GoogleBooksService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module which provides all required dependencies about services
 */
@Module
@Suppress("unused")
object ServiceModule {
    @Provides
    @Reusable
    @JvmStatic
    fun provideBooksApi(retrofit: Retrofit): GoogleBooksService {
        return retrofit.create(GoogleBooksService::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}