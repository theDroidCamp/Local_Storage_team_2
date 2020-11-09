package com.coolbanter.local_storage_team_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.coolbanter.local_storage_team_2.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignUpBinding

    private lateinit var name: EditText
    private lateinit var emailAddress: EditText
    private lateinit var schoolName: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)




        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        name = binding.nameEt
        emailAddress = binding.emailAddressEt
        schoolName = binding.schoolNameEt
        password = binding.passwordEt



        binding.btnSignUp.setOnClickListener {
            isValidEmail()
            saveData()


        }
    }

    private fun isValidEmail() {
        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress.toString()).matches()){
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
        return
        }
    }

//    private fun isValidEmail(emailAddress: String) {
//        if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress.toString()).matches()) {
//            Toast.makeText(this, "Invalid email address", Toast.LENGTH_LONG).show()
//        }else {
//            return
//        }
//    }
             private fun saveData() {
                if (name.text.isEmpty()) {
                    name.error = "Please enter your name"
                    return
                }
                if (emailAddress.text.isEmpty()) {
                    emailAddress.error = "Please enter your email address"
                    return
                }
                 
                if (schoolName.text.isEmpty()) {
                    schoolName.error = "Please enter the name of your school"
                    return
                }

                if (password.text.isEmpty()) {
                    password.error = "Please enter password"
                    return
                }

                 // This will check if valid email pattern is followed, else it will return



                val  mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

                val editor = mypref.edit()

                 if (name.text.toString().isNotEmpty() &&
                         emailAddress.text.toString().isNotEmpty() &&
                         schoolName.text.toString().isNotEmpty() &&
                         password.text.toString().isNotEmpty()) {

                     editor.putString("name", name.text.toString())
                     editor.putString("email", emailAddress.text.toString())
                     editor.putString("school", schoolName.text.toString())
                     editor.putString("password", password.text.toString())

                     editor.apply()
                     startActivity(Intent(this, LoginActivity::class.java))
                     Toast.makeText(this, "Sign up successful, please login", Toast.LENGTH_LONG).show()
                 }






            }
}
