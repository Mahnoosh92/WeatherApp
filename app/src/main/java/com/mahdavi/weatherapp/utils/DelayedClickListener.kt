package com.mahdavi.weatherapp.utils

import android.os.Handler
import android.view.View
import java.lang.Math.abs

class DelayedClickListener(private val delayMillis : Long = 500 , private val function: (view: View?) -> Unit) : View.OnClickListener {

    override fun onClick(v: View?) {
        v?.let { view ->
            view.isClickable = false
            Handler().postDelayed({ view.isClickable = true }, abs(delayMillis))
        }
        function.invoke(v)
    }

}