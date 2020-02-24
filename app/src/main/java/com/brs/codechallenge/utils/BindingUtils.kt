package com.brs.codechallenge.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.brs.codechallenge.R
import com.brs.codechallenge.constants.Constants.Companion.AUTHOR_NOT_AVAIABLE
import com.brs.codechallenge.constants.Constants.Companion.INFO_NOT_AVAILABLE
import com.squareup.picasso.Picasso

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value -> view.visibility = value?:View.VISIBLE})
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity:AppCompatActivity? = view.getParentActivity()
    if(parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value?: INFO_NOT_AVAILABLE})
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("authors")
fun setAuthors(view: TextView, authors: MutableLiveData<List<String>>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null)
        authors.observe(
            parentActivity,
            Observer { value -> view.text = value?.joinToString(", ") ?: AUTHOR_NOT_AVAIABLE })
}

@BindingAdapter("thumbUrl")
fun setImageWithThumbUrl(view: ImageView, thumbUrl: String?) {
    val picasso: Picasso = Picasso.with(view.context)
    picasso.load(thumbUrl)
        .placeholder(R.drawable.book)
        .error(R.drawable.book)
        .centerCrop()
        .fit()
        .into(view)
}
