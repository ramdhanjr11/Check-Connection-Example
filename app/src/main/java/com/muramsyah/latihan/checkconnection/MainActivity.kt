package com.muramsyah.latihan.checkconnection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkStatusHelper(this).observe(this, {
            findViewById<TextView>(R.id.tv_connection).text = when(it) {
                NetworkStatus.Available -> {
                    Log.d("connection", "onCreate: internet available")
                    "Network Connection Established"
                }
                NetworkStatus.Unavailable -> {
                    Log.d("connection", "onCreate: internet Unavailable")
                    "No Internet"
                }
            }
        })
    }
}