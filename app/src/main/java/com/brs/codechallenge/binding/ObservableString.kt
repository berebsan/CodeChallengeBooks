package com.brs.codechallenge.binding

import androidx.databinding.ObservableField
import android.text.TextUtils

/**
 * An observable class that holds a primitive [String].
 *
 *
 * This is meant to be used as a replacement for ObservableField<String>.
 * This also fixes the bug in [ObservableField.set]
 * by doing a String compare instead of an instance compare.
</String> *
 *
 * Created by rob on 1/18/17.
 */
class ObservableString : ObservableField<String> {
    //region Fields

    private var mStringValue: String? = null

    //endregion

    //region Constructors

    /**
     * Creates an [ObservableString] with the given initial value.
     *
     * @param value the initial value for the [ObservableString]
     */
    constructor(value: String) {
        mStringValue = value
    }

    /**
     * Creates an [ObservableString] with the initial value of `null`.
     */
    constructor() {}

    //endregion

    //region Methods

    /**
     * @return the stored value.
     */
    override fun get(): String? {
        return mStringValue
    }

    /**
     * Set the stored value.
     */
    override fun set(value: String) {
        if (!TextUtils.equals(value, mStringValue)) {
            mStringValue = value
            notifyChange()
        }
    }

    //endregion
}