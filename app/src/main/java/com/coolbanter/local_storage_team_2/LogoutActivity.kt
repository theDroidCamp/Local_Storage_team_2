package com.coolbanter.local_storage_team_2


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coolbanter.local_storage_team_2.databinding.ActivityLogoutBinding
import com.google.android.material.textview.MaterialTextView


class LogoutActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLogoutBinding
    private lateinit var name : MaterialTextView
    private lateinit var emailAddress : MaterialTextView
    private lateinit var school : MaterialTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        name = binding.nameTv
        emailAddress = binding.emailTv
        school = binding.schoolTv

        showData()


        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun showData() {
        val userData = getSharedPreferences("mypref", Context.MODE_PRIVATE)
        name.text = userData.getString("name", " ")
        emailAddress.text = userData.getString("email", " ")
        school.text = userData.getString("school", " ")

    }


}