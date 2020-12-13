package com.temsi.whooshtest.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("scooterName")
fun TextView.setScooterName(name: String) {
    text = name
}

@BindingAdapter("scooterStatus")
fun TextView.setScooterStatus(status: String) {
    text = status
}
@BindingAdapter("scooterComment")
fun TextView.setScooterComment(comment: String) {
    text = comment
}