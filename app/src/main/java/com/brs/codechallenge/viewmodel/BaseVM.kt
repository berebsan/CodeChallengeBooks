package com.brs.codechallenge.viewmodel

import androidx.lifecycle.ViewModel
import com.brs.codechallenge.model.injection.DaggerVMInjector
import com.brs.codechallenge.model.injection.ServiceModule
import com.brs.codechallenge.model.injection.VMInjector

abstract class BaseVM: ViewModel(){
    private val injector: VMInjector = DaggerVMInjector
        .builder()
        .serviceModule(ServiceModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is SearchBooksVM -> injector.inject(this)
        }
    }
}