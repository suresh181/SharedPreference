package com.example.sharedpreference

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreference.databinding.ActivityMainBinding
import com.example.sharedpreference.utils.SharedPreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var getSharedPre:SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private lateinit var color:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (getColor() != null){
            startMainActivity2()
            finish()
        }

        binding.btnSave.setOnClickListener {
            saveColor("green")
            startMainActivity2()
        }

    }

    private fun startMainActivity2(){
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

    private fun saveColor(name:String){
        val sharedPreferenceHelper = SharedPreferenceHelper.getInstance(this)
        sharedPreferenceHelper.add("color",name)
    }
    private fun getColor():String?{
        val sharedPreferenceHelper = SharedPreferenceHelper.getInstance(this)
        return sharedPreferenceHelper.get("color")

    }


}