package com.furkancolak.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.furkancolak.storingdata.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var sharedPref : SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // SharedPreferences - XML - Key Values
        sharedPref = getSharedPreferences("com.furkancolak.storingdata",Context.MODE_PRIVATE)
        val userAgePref = sharedPref.getInt("age",-1)//kayıtlı bir şey yoksa -1 döndürür
        if (userAgePref == -1){
            binding.textView.text = "Your Age :"
        }
        else{
            binding.textView.text = "Your Age " + userAgePref
        }
    }
    fun bSAVE(view : View){
        var age = binding.editText.text.toString().toIntOrNull()
        if(age != null){
            binding.textView.text = "Your age : "  + age
            sharedPref.edit().putInt("age",age).apply() // anahtar eşleşmesi

        }
    }
    fun bDELETE(view : View){
        sharedPref.edit().remove("age").apply()
        binding.textView.text = "Your Age:"
    }

}