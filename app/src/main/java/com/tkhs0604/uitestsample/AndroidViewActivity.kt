package com.tkhs0604.uitestsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.tkhs0604.uitestsample.databinding.ActivityAndroidViewBinding

class AndroidViewActivity : ComponentActivity() {

    private lateinit var binding: ActivityAndroidViewBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.counterLabel.text ="count: $counter"
        binding.countUpButton.setOnClickListener {
            counter++
            binding.counterLabel.text ="count: $counter"
        }
    }
}
