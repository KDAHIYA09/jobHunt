package com.example.gyannproject.splashAndOnboarding

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gyannproject.MainActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding // Declare the binding object
    private val splashTimeOut: Long = 3000 // Splash screen timeout duration in milliseconds (3 seconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Simulate some loading time using Coroutine
        CoroutineScope(Dispatchers.Main).launch {
            delay(splashTimeOut) // Delay execution for splashTimeOut milliseconds

                navigateToActivity(OnboardingActivity())

            finish() // Finish the splash activity to prevent going back to it
        }

    }

    private fun navigateToActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        finish()
    }

}
