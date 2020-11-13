package com.ozimos.android_styling_exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozimos.android_styling_exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btMainNum1.setOnClickListener { startActivity(Intent(this@MainActivity, NumberOne::class.java)) }
            btMainNum2.setOnClickListener { startActivity(Intent(this@MainActivity, NumberTwo::class.java)) }
            btMainNum3.setOnClickListener { startActivity(Intent(this@MainActivity, HomeActivity::class.java)) }
        }
    }
}