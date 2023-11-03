package com.isilsubasi.roommvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isilsubasi.roommvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

    }


}