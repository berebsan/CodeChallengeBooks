package com.brs.codechallenge.utils

import com.brs.codechallenge.model.api.VolumeModel

interface ApiResponseUtils {
    fun showLoader(isLoading: Boolean)
    fun showResult(totalItems: Int, volumeList: List<VolumeModel>)
    fun showError(message: String?)
}