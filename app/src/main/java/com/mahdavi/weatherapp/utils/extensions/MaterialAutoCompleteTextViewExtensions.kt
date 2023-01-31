package com.mahdavi.weatherapp.utils.extensions

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.PublishProcessor

fun MaterialAutoCompleteTextView.getQueryTextChange(): Flowable<String> {
    val query = PublishProcessor.create<String>()
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            /* NO-OP */
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            query.onNext(p0?.toString() ?: "")

        }

        override fun afterTextChanged(p0: Editable?) {
            /* NO-OP */
        }
    })
    return query
}
