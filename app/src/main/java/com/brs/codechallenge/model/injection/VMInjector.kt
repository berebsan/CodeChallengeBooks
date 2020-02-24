package com.brs.codechallenge.model.injection

import com.brs.codechallenge.viewmodel.SearchBooksVM
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ServiceModule::class)])
interface VMInjector {
    fun inject(searchBooksVM: SearchBooksVM)

    @Component.Builder
    interface Builder {
        fun build(): VMInjector

        fun serviceModule(networkModule: ServiceModule): Builder
    }
}