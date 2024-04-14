package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var tvInput : TextView? = null
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.textView)
    }
    fun digit( view: View){
        tvInput?.append((view as Button).text)
        lastNumeric=true
        lastDot=false
    }
    fun onOpClick(view : View){
        tvInput?.text?.let {
        if(lastNumeric && !isOperatorAdded(it.toString())){
                tvInput?.append((view as Button).text)
            lastDot=false
            lastNumeric=false
        }
        }
    }
    fun erase(view:View){
       var value = tvInput?.text.toString()
        value = value.substring(0,value.length -1)
        tvInput?.text = value
    }
    fun equalAction(view: View){
        if(lastNumeric){
            var tvValue = tvInput?.text.toString()
            var prefix =""
            try{
                if(tvValue.startsWith("-")){
                    tvValue = tvValue.substring(1)
                    prefix = "-"

                }
                //for performing subtraction
                when {
                    tvValue.contains("-") -> {
                        val splitValue = tvValue.split("-")
                        //converting the splitval into 2 parts before - and after -
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                        tvInput?.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                    }
                    //for addition
                    tvValue.contains("+") -> {
                        val splitValue = tvValue.split("+")
                        //converting the splitval into 2 parts before + and after +
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                        tvInput?.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                    }
                    //division
                    tvValue.contains("/") -> {
                        val splitValue = tvValue.split("/")
                        //converting the splitval into 2 parts before - and after -
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                        tvInput?.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                    }
                    //modulus
                    tvValue.contains("%") -> {
                        val splitValue = tvValue.split("%")
                        //converting the splitVal into 2 parts before - and after -
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                        tvInput?.text = removeZeroAfterDot((one.toDouble() % two.toDouble()).toString())
                    }
                    //multiplication
                    tvValue.contains("x") -> {
                        val splitValue = tvValue.split("x")
                        //converting the splitval into 2 parts before - and after -
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if(prefix.isNotEmpty()){
                            one = prefix + one
                        }
                        tvInput?.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                    }
                }

            }catch (e : ArithmeticException){
                e.printStackTrace()
            }
        }
    }
    fun dot(view : View){
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastDot = true
            lastNumeric=false
        }

    }
    fun allClear(view : View){
        tvInput?.text = ""
    }
    private fun isOperatorAdded( value : String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("+") ||value.contains("-") ||value.contains("x") || value.contains("%")
        }
    }
    private fun removeZeroAfterDot(result : String) : String{
        var value = result
        if(value.contains(".0")){
            value = value.substring(0,value.length - 2)
        }
        return value
    }
}