package com.example.gyannproject.signUpscreens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.Selection.setSelection
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds
import com.example.gyannproject.LogInScreens.LogInActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignupBinding
    lateinit var emailText : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.emailETField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val emailValue = binding.emailETField.text.toString().trim()
                checkEmail(emailValue)
            }

            override fun afterTextChanged(s: Editable?) {
                val emailValue = binding.emailETField.text.toString().trim()
                checkEmail(emailValue)
            }


        })

        binding.passwordETField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var pass = binding.passwordETField.text.toString().trim()
                if (!isPasswordValid(pass)){
                    binding.passwordETField.setBackgroundResource(R.drawable.edittext_error_background)
                    binding.PsswordErrorMsg.text = "Password must be 8-16 characters long with 1 uppercase, 1 lowercase, 1 number and 1 special character."
                    binding.PsswordErrorMsg.visibility = View.VISIBLE
                }else{
                    binding.passwordETField.setBackgroundResource(R.drawable.edittext_background)
                    binding.PsswordErrorMsg.visibility = View.GONE
                }

            }

            override fun afterTextChanged(s: Editable?) {
                var pass = binding.passwordETField.text.toString().trim()
                if (!isPasswordValid(pass)){
                    binding.passwordETField.setBackgroundResource(R.drawable.edittext_error_background)
                    binding.PsswordErrorMsg.text = "Password must be 8-16 characters long with 1 uppercase, 1 lowercase, 1 number and 1 special character."
                    binding.PsswordErrorMsg.visibility = View.VISIBLE
                }else{
                    binding.passwordETField.setBackgroundResource(R.drawable.edittext_background)
                    binding.PsswordErrorMsg.visibility = View.GONE
                }
            }

        })

        binding.repeatPasswordETField.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                var pass = binding.passwordETField.text.toString().trim()
                var confirmPass = binding.repeatPasswordETField.text.toString().trim()
                if (confirmPass != pass){
                    binding.repeatPasswordETField.setBackgroundResource(R.drawable.edittext_error_background)
                    binding.confirmPasswordErrorMsg.text = "Password and confirm password do not match"
                    binding.confirmPasswordErrorMsg.visibility = View.VISIBLE
                }else{
                    binding.repeatPasswordETField.setBackgroundResource(R.drawable.edittext_background)
                    binding.confirmPasswordErrorMsg.text = "Password and confirm password do not match"
                    binding.confirmPasswordErrorMsg.visibility = View.GONE
                }
            }

        })

        var isIcon1Visible = true

        binding.passwordETField.setDrawableClickListener(object : DrawableClickListener {
            override fun onClick(target: DrawableClickListener.DrawablePosition) {
                if (target == DrawableClickListener.DrawablePosition.END) {
                    if (isIcon1Visible) {
                        binding.passwordETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_open), null)
                        binding.passwordETField.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    } else {
                        binding.passwordETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_off), null)
                        binding.passwordETField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }
                    isIcon1Visible = !isIcon1Visible // Toggle the flag
                }
            }
        })

        binding.repeatPasswordETField.setDrawableClickListener(object : DrawableClickListener {
            override fun onClick(target: DrawableClickListener.DrawablePosition) {
                if (target == DrawableClickListener.DrawablePosition.END) {
                    if (isIcon1Visible) {
                        binding.repeatPasswordETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_open), null)
                        binding.repeatPasswordETField.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    } else {
                        binding.repeatPasswordETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.eye_off), null)
                        binding.repeatPasswordETField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    }
                    isIcon1Visible = !isIcon1Visible // Toggle the flag
                }
            }
        })

        binding.createAccountBtn.setOnClickListener(View.OnClickListener {
            val emailValue = binding.emailETField.text.toString().trim()
            var pass = binding.passwordETField.text.toString().trim()
            var confirmPass = binding.repeatPasswordETField.text.toString().trim()

            if(isPasswordValid(pass) && pass == confirmPass && checkEmail(emailValue)){
                navigateToActivity(VerifyOTPActivity())
            }else{
                Toast.makeText(this, "Please enter all the values correctly.", Toast.LENGTH_SHORT).show()
            }

        })

        binding.loginText.setOnClickListener(View.OnClickListener {
            navigateToActivity(LogInActivity())
        })



    }


    private fun checkEmail(email: String): Boolean{
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        var isEmail = emailRegex.toRegex().matches(email)

        if (TextUtils.isEmpty(email)) {
            binding.emailETField.setBackgroundResource(R.drawable.edittext_error_background)
            binding.emailETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.alert_circle), null)
            binding.emailErrorMsg.text = "Enter email"
            binding.emailErrorMsg.visibility = View.VISIBLE
            return false
        }else if(isEmail == false){
            binding.emailETField.setBackgroundResource(R.drawable.edittext_error_background)
            binding.emailETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, resources.getDrawable(R.drawable.alert_circle), null)
            binding.emailErrorMsg.text = "Wrong email format"
            binding.emailErrorMsg.visibility = View.VISIBLE
            return false
        }else{
            binding.emailETField.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
            binding.emailETField.setBackgroundResource(R.drawable.edittext_background)
            binding.emailErrorMsg.visibility = View.GONE
            return true
        }

        return true
    }

    fun isPasswordValid(password: String): Boolean {
        // Define regex patterns for each criteria
        val uppercasePattern = Regex("[A-Z]")
        val lowercasePattern = Regex("[a-z]")
        val digitPattern = Regex("\\d")
        val specialCharPattern = Regex("[^A-Za-z0-9]")

        // Check if password meets all criteria
        val hasUppercase = uppercasePattern.containsMatchIn(password)
        val hasLowercase = lowercasePattern.containsMatchIn(password)
        val hasDigit = digitPattern.containsMatchIn(password)
        val hasSpecialChar = specialCharPattern.containsMatchIn(password)
        val isLengthValid = password.length in 8..16

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar && isLengthValid
    }

    private fun navigateToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        finish()
    }

}