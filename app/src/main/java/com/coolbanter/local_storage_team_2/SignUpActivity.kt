package com.coolbanter.local_storage_team_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.coolbanter.local_storage_team_2.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    lateinit var name_et: EditText
    lateinit var email_address_et: EditText
    lateinit var school_name_et: EditText
    lateinit var password_et: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        name_et = binding.nameEt
        email_address_et = binding.emailAddressEt
        school_name_et = binding.schoolNameEt
        password_et = binding.passwordEt



        binding.btnSignUp.setOnClickListener {
            saveData()

        }
    }
            private fun saveData() {
                if (name_et.text.isEmpty()) {
                    name_et.error = "Please enter your name"
                    return
                }
                if (email_address_et.text.isEmpty()) {
                    email_address_et.error = "Please enter your email address"
                    return
                }
                if (school_name_et.text.isEmpty()) {
                    school_name_et.error = "Please enter the name of your school"
                    return
                }

                if (password_et.text.isEmpty()) {
                    password_et.error = "Please enter password"
                    return
                }

                val  mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

                val editor = mypref.edit()

                editor.putString("name", name_et.text.toString())
                editor.putString("email", email_address_et.text.toString())
                editor.putString("school", school_name_et.text.toString())
                editor.putString("password", password_et.text.toString())

                editor.apply()

                Toast.makeText(this, "Sign up successful", Toast.LENGTH_LONG).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
}
