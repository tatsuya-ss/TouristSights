package com.example.touristsights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.touristsights.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        val tag = "ListFragment"
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = ListFragment()
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.content, fragment, tag)
            }.commit()
        }

    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}