package com.coolbanter.local_storage_team_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.coolbanter.local_storage_team_2.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


            
        

      binding.btnLogin.setOnClickListener {
          saveData()

          //This will change the current screen to another screen





        }
    }
        //To save data with shared preference
    private fun saveData() {
            //If field is empty will show (Input email address)
            if (binding.emailAddressEt.text!!.isEmpty()) {
                binding.emailAddressEt.error = "Input your email address!!"
                return
            }
            //If field is empty will show (Password is empty)
            if (binding.passwordEt.text!!.isEmpty()) {
                binding.passwordEt.error = "Password is empty!"
                return
            }


            val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

            val email = mypref.getString("email", "")
            val password = mypref.getString("password", "")

            if (email!! == binding.emailAddressEt.text.toString() &&
                    password!! == binding.passwordEt.text.toString()) {
                startActivity(Intent(this, LogoutActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Incorrect email or password!", Toast.LENGTH_LONG).show()
            }

        }
}