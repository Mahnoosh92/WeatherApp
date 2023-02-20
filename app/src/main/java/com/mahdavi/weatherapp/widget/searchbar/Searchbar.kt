package com.mahdavi.weatherapp.widget.searchbar

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.card.MaterialCardView
import com.mahdavi.weatherapp.R
import com.mahdavi.weatherapp.databinding.SearchHeaderLayoutBinding
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.processors.PublishProcessor
import timber.log.Timber
import java.util.concurrent.TimeUnit

class Searchbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val binding = SearchHeaderLayoutBinding.inflate(LayoutInflater.from(context), this)
    private var callback: SearchbarClickedCallback? = null
    private val textChange = PublishProcessor.create<String>()

    init {
        loadAttributes(attrs, defStyleAttr)
        setupUiListener()
    }

    private fun setupUiListener() {
        binding.cardViewSearchBar.setOnClickListener {
            callback?.onClickSearchBar()
        }
        binding.searchEditText.doAfterTextChanged {
            it?.let {
                textChange.onNext(it.toString())
            }
        }
    }

    private fun loadAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        var typedArray: TypedArray? = null
        try {
            typedArray = context.obtainStyledAttributes(
                attrs, R.styleable.Searchbar, defStyleAttr, 0
            )

            binding.apply {
                searchEditText.isEnabled =
                    typedArray.getBoolean(R.styleable.Searchbar_sb_enabled, true)
                searchEditText.setText(typedArray.getString(R.styleable.Searchbar_sb_text))
            }
        } catch (exp: Exception) {
            Timber.e(exp)
        } finally {
            typedArray?.recycle()
        }
    }

    fun setText(value: String) {
        binding.searchEditText.setText(value)
    }

    fun getTextOnChange(): Flowable<String> {
        return textChange.debounce(200, TimeUnit.MILLISECONDS)
    }
}

interface SearchbarClickedCallback {
    fun onClickSearchBar()
}