package com.coolbanter.local_storage_team_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coolbanter.local_storage_team_2.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }




}
