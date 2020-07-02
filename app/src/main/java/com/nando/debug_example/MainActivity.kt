package com.nando.debug_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nando.debug.Debug

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Debug(this, "Lol").error()
    }



}