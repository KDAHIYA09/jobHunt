package com.example.gyannproject.forgotPasswordScreens

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gyannproject.LogInScreens.LogInActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityPasswordResetBinding
import com.example.gyannproject.splashAndOnboarding.ObjectiveActivity

class PasswordResetActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPasswordResetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPasswordResetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dummyOtp = 100000
        Toast.makeText(this , "dummyOtp is : $dummyOtp", Toast.LENGTH_LONG).show()
        //create an array of all text field of otp digits
        val otpDigits = arrayOfNulls<EditText>(6)
        otpDigits[0] = binding.otp1resetPassword
        otpDigits[1] = binding.otp2resetPassword
        otpDigits[2] = binding.otp3resetPassword
        otpDigits[3] = binding.otp4resetPassword
        otpDigits[4] = binding.otp5resetPassword
        otpDigits[5] = binding.otp6resetPassword

        //add listner to all fields/array element to make sure cursour moves to next field after 1 digit has been typed in
        for (i in 0..4){
            otpDigits[i]?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1){
                        otpDigits[i+1]?.requestFocus()
                    }
                }


            })

            //for last otp digit we want that focus moves handling submission event
            otpDigits[5]?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                }

                override fun afterTextChanged(s: Editable?) {

                }

            })


        }

        binding.submitOtpBtnresetPassword.setOnClickListener(View.OnClickListener {
            val otp = StringBuilder()
            for (i in 0..5){
                otp.append(otpDigits[i]?.text)
            }
            //Toast.makeText(this , "Otp is : $otp", Toast.LENGTH_LONG).show()

            if (otp.toString() == dummyOtp.toString()){
                setSuccessMessage()
            }else if(otpDigits.any { it?.text.toString().isEmpty() }){
                setErrorMessage()
                binding.resetPasswordErrorMsg.text = "Please enter OTP"
                binding.resetPasswordErrorMsg.visibility = View.VISIBLE
            }else{
                setErrorMessage()
                binding.resetPasswordErrorMsg.text = "Wrong code"
                binding.resetPasswordErrorMsg.visibility = View.VISIBLE
            }

        })

        binding.resetPasswordErrorMsg.setOnClickListener(View.OnClickListener {
            otpDigits.forEach { editText ->
                editText?.setText("")
            }

            otpDigits[0]?.requestFocus()

        })

    }

    private fun setSuccessMessage(){
        binding.resetPasswordErrorMsg.visibility = View.GONE
        binding.otp1resetPassword.setBackgroundResource(R.drawable.edittext_background)
        binding.otp2resetPassword.setBackgroundResource(R.drawable.edittext_background)
        binding.otp3resetPassword.setBackgroundResource(R.drawable.edittext_background)
        binding.otp4resetPassword.setBackgroundResource(R.drawable.edittext_background)
        binding.otp5resetPassword.setBackgroundResource(R.drawable.edittext_background)
        binding.otp6resetPassword.setBackgroundResource(R.drawable.edittext_background)
        navigateToActivity(SetNewPasswordActivity())
    }

    private fun setErrorMessage(){
        binding.otp1resetPassword.setBackgroundResource(R.drawable.edittext_error_background)
        binding.otp2resetPassword.setBackgroundResource(R.drawable.edittext_error_background)
        binding.otp3resetPassword.setBackgroundResource(R.drawable.edittext_error_background)
        binding.otp4resetPassword.setBackgroundResource(R.drawable.edittext_error_background)
        binding.otp5resetPassword.setBackgroundResource(R.drawable.edittext_error_background)
        binding.otp6resetPassword.setBackgroundResource(R.drawable.edittext_error_background)

    }

    private fun navigateToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
//        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
//        sharedPreferences.edit().putBoolean("isOnboardingShown", true).apply()
        finish()
    }

}