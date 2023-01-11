package com.esaudev.customviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.esaudev.customviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.testButton.setOnClickListener{
            isLoading = !isLoading
            binding.progressButton.setLoading(isLoading)
        }

        binding.progressButton.setOnClickListener {
            Toast.makeText(this, "onClick Triggered", Toast.LENGTH_SHORT).show()
        }
    }
}