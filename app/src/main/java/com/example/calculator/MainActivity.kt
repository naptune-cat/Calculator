package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var lastNumeric = false
    var stateError = false
    var lastDot = false
    private lateinit var expression : Expression
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onOpClick(view: View){

    }
    fun allClear(view: View){

    }
    fun onDot(view: View){

    }
    fun erase(view: View){

    }
    fun equalAction(view: View){

    }
    fun digit(view: View){

    }
}