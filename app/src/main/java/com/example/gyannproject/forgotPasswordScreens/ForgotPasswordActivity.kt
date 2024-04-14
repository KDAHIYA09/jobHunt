package com.example.gyannproject.forgotPasswordScreens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gyannproject.LogInScreens.LogInActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityForgotPasswordBinding
import com.example.gyannproject.signUpscreens.VerifyOTPActivity

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val storedEmail = "khushbu@indicchain.com"

        binding.emailETFieldforgotPassword.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Dummy email is: $storedEmail", Toast.LENGTH_LONG).show()
        })

        binding.forgotPasswordBackArrow.setOnClickListener(View.OnClickListener {
            navigateToActivity(LogInActivity())
        })



        binding.resetPasswordBtn.setOnClickListener(View.OnClickListener {
            var emailVal = binding.emailETFieldforgotPassword.text.toString().trim()
            if (emailVal == storedEmail){
                binding.emailETFieldforgotPassword.setBackgroundResource(R.drawable.edittext_background)
                binding.emailErrorMsgforgotPassword.visibility = View.GONE
                binding.emailETFieldforgotPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
                navigateToActivity(PasswordResetActivity())
            }else{
                binding.emailETFieldforgotPassword.setBackgroundResource(R.drawable.edittext_error_background)
                binding.emailErrorMsgforgotPassword.text = "Email does not exist"
                binding.emailErrorMsgforgotPassword.visibility = View.VISIBLE
                binding.emailETFieldforgotPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.alert_circle), null)
            }
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