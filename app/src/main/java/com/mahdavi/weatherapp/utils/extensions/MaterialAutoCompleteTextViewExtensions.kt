package com.mahdavi.weatherapp.utils.extensions

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.BehaviorProcessor

fun MaterialAutoCompleteTextView.getQueryTextChange(): Flowable<String> {
    val query = BehaviorProcessor.create<String>()
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            /* NO-OP */
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            p0?.let {
                if (it.isNotEmpty()) {
                    query.onNext(it.toString())
                }
            }
        }

        override fun afterTextChanged(p0: Editable?) {
            /* NO-OP */
        }
    })
    return query
}