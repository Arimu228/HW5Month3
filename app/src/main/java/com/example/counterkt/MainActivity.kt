package com.example.counterkt

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.counterkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counterValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        listener()
        setContentView(binding.root)

    }

    @SuppressLint("CommitTransaction")
    private fun listener() {
        binding.button.setOnClickListener {
            binding.counter.text = counterValue.toString()
            counterValue++
            if (counterValue == 11) {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, SecondFragment())
                    .commit()
                binding.button.visibility = View.GONE
                binding.counter.visibility = View.GONE
            }
        }
    }
}