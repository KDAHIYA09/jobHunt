package com.example.gyannproject.LogInScreens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gyannproject.MainActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityLogInBinding
import com.example.gyannproject.forgotPasswordScreens.ForgotPasswordActivity
import com.example.gyannproject.signUpscreens.DrawableClickListener
import com.example.gyannproject.signUpscreens.SignupActivity

class LogInActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storedEmail = "khushbu@indicchain.com"
        val storedPassword = "Mobiloitte!1"

        var isIcon1Visible = true
        binding.passwordETFieldLogin.setDrawableClickListener(object : DrawableClickListener {
            override fun onClick(target: DrawableClickListener.DrawablePosition) {
                if (target == DrawableClickListener.DrawablePosition.END) {
                    if (isIcon1Visible) {
                        binding.passwordETFieldLogin.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_open), null)
                        binding.passwordETFieldLogin.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    } else {
                        binding.passwordETFieldLogin.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_off), null)
                        binding.passwordETFieldLogin.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }
                    isIcon1Visible = !isIcon1Visible // Toggle the flag
                }
            }
        })

        binding.emailETFieldLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Dummy email is: $storedEmail", Toast.LENGTH_LONG).show()
        })

        binding.passwordETFieldLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Dummy password is: $storedPassword", Toast.LENGTH_LONG).show()
        })

        binding.loginBtn.setOnClickListener(View.OnClickListener {
            var email = binding.emailETFieldLogin.text.toString().trim()
            var pass = binding.passwordETFieldLogin.text.toString().trim()
            if (email == "khushbu@indicchain.com" && pass == "Mobiloitte!1") {
                binding.emailETFieldLogin.setBackgroundResource(R.drawable.edittext_background)
                binding.emailErrorMsgLogin.visibility = View.GONE
                binding.emailETFieldLogin.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
                binding.passwordETFieldLogin.setBackgroundResource(R.drawable.edittext_background)
                binding.PsswordErrorMsgLogin.visibility = View.GONE
                navigateToActivity(MainActivity())
            } else {
                binding.emailETFieldLogin.setBackgroundResource(R.drawable.edittext_error_background)
                binding.emailErrorMsgLogin.text = "Email does not exist"
                binding.emailErrorMsgLogin.visibility = View.VISIBLE
                binding.emailETFieldLogin.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.alert_circle), null)
                binding.passwordETFieldLogin.setBackgroundResource(R.drawable.edittext_error_background)
                binding.PsswordErrorMsgLogin.text = "Password do not match"
                binding.PsswordErrorMsgLogin.visibility = View.VISIBLE
            }
        })

        binding.SignUpTextLogin.setOnClickListener(View.OnClickListener {
            navigateToActivity(SignupActivity())
        })

        binding.forgotPasswordFieldLogin.setOnClickListener(View.OnClickListener {
            navigateToActivity(ForgotPasswordActivity())
        })


    }

    private fun navigateToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        sharedPreferences.edit().putBoolean("isOnboardingShown", true).apply()
        finish()
    }

}