package com.coolbanter.local_storage_team_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coolbanter.local_storage_team_2.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LogoutActivity::class.java))
            finish()
        

    }
    




    }
}