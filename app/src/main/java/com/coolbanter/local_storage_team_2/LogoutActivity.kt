package com.coolbanter.local_storage_team_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LogutActivity(intent: Intent) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
    }
}