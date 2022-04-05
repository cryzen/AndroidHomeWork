package com.example.androidhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("LifecycleTag", "Activity: onCreate")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        title = "Home work"

        if (savedInstanceState == null) {
            addSenderFragment()
        }
    }

    private fun addSenderFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, SenderFragment())
            .commit()
    }
}