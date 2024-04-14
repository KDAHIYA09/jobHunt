package com.example.gyannproject.splashAndOnboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.example.gyannproject.LogInScreens.LogInActivity
import com.example.gyannproject.MainActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityOnboardingBinding
import com.example.gyannproject.signUpscreens.SignupActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding // Declare the binding object
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layouts = listOf(
            R.layout.onboarding_screen_1,
            R.layout.onboarding_screen_2,
            R.layout.onboarding_screen_3
        )
        viewPagerAdapter = ViewPagerAdapter(this, layouts)
        binding.viewPager.adapter = viewPagerAdapter


        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                // Perform action based on the selected item in the list
                when (position) {
                    0 -> {
                        binding.viewpagerBottomMenuOneSelected.visibility = View.VISIBLE
                        binding.viewpagerBottomMenuOneUnselected.visibility = View.GONE

                        binding.viewpagerBottomMenuTwoUnselected.visibility = View.VISIBLE
                        binding.viewpagerBottomMenuTwoSelected.visibility = View.GONE

                        binding.viewpagerBottomMenuThreeSelected.visibility = View.GONE
                        binding.viewpagerBottomMenuThreeUnselected.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.viewpagerBottomMenuOneSelected.visibility = View.GONE
                        binding.viewpagerBottomMenuOneUnselected.visibility = View.VISIBLE

                        binding.viewpagerBottomMenuTwoUnselected.visibility = View.GONE
                        binding.viewpagerBottomMenuTwoSelected.visibility = View.VISIBLE

                        binding.viewpagerBottomMenuThreeSelected.visibility = View.GONE
                        binding.viewpagerBottomMenuThreeUnselected.visibility = View.VISIBLE

                    }
                    2 -> {
                        binding.viewpagerBottomMenuOneSelected.visibility = View.GONE
                        binding.viewpagerBottomMenuOneUnselected.visibility = View.VISIBLE

                        binding.viewpagerBottomMenuTwoUnselected.visibility = View.VISIBLE
                        binding.viewpagerBottomMenuTwoSelected.visibility = View.GONE

                        binding.viewpagerBottomMenuThreeSelected.visibility = View.VISIBLE
                        binding.viewpagerBottomMenuThreeUnselected.visibility = View.GONE

                    }

                }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageScrollStateChanged(state: Int) {
                // Unused
            }
        })

        binding.signupBtn.setOnClickListener(View.OnClickListener {
            navigateToActivity(SignupActivity())
        })

        binding.logInBtnOnboard.setOnClickListener(View.OnClickListener {
            navigateToActivity(LogInActivity())
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