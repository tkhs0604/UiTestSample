package com.tkhs0604.uitestsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.tkhs0604.uitestsample.databinding.ActivityAndroidViewBinding

class AndroidViewActivity : ComponentActivity() {

    private lateinit var binding: ActivityAndroidViewBinding
    private var counter = Counter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterLabel.text = counter.toString()
        binding.countUpButton.setOnClickListener {
            counter.increment()
            binding.counterLabel.text = counter.toString()
        }
    }

    private class Counter {
        private var value: Int = 0

        fun increment() {
            value++
        }

        override fun toString(): String {
            return "count: $value"
        }
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, AndroidViewActivity::class.java)
    }
}
