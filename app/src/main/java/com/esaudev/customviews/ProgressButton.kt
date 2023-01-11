package com.esaudev.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.esaudev.customviews.databinding.CvProgressButtonBinding

class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var buttonText: String = ""
    private val binding: CvProgressButtonBinding

    init {
        binding = CvProgressButtonBinding.inflate(LayoutInflater.from(context), this, true)
        loadAttr(attrs, defStyleAttr)
    }

    private fun loadAttr(attrs: AttributeSet?, defStyleAttr: Int) {
        val arr = context.obtainStyledAttributes(
            attrs,
            R.styleable.ProgressButton,
            defStyleAttr,
            0
        )

        buttonText = arr.getString(R.styleable.ProgressButton_buttonText).orEmpty()
        val loading = arr.getBoolean(R.styleable.ProgressButton_isLoading, false)

        arr.recycle()
        setText(buttonText)
        setLoading(loading)
    }

    fun setLoading(isLoading: Boolean){
        binding.button.isEnabled = !isLoading
        binding.loader.isVisible = isLoading
        binding.button.text = if (isLoading) "" else buttonText
    }

    fun setText(text : String?) {
        binding.button.text = text
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        binding.button.setOnClickListener(l)
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        binding.button.isEnabled = enabled
    }
}