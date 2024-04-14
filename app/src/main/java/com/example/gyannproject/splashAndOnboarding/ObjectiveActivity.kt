package com.example.gyannproject.splashAndOnboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gyannproject.MainActivity
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityObjectiveBinding
import com.example.gyannproject.jobseeker.JobseekersMainActivity
import com.example.gyannproject.organization.OrganizationMainActivity

class ObjectiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityObjectiveBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityObjectiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jobseekerLayout.setOnClickListener(View.OnClickListener {
            binding.jobseekerLayout.setBackgroundResource(R.drawable.objective_selected_background)
            binding.jobseekerHeading.setTextColor(resources.getColor(R.color.white))
            binding.jobseekerSubheading.setTextColor(resources.getColor(R.color.subheading_objective_select_color))
            binding.organizationLayout.setBackgroundResource(R.drawable.edittext_background)
            binding.organizationHeading.setTextColor(resources.getColor(R.color.headingColor))
            binding.organizationSubheading.setTextColor(resources.getColor(R.color.edittexthintcolor))
            binding.getStartedBtn.visibility = View.VISIBLE
            binding.getStartedBtn.setOnClickListener(View.OnClickListener {
                navigateToActivity(JobseekersMainActivity())
            })
        })

        binding.organizationLayout.setOnClickListener(View.OnClickListener {
            binding.organizationLayout.setBackgroundResource(R.drawable.objective_selected_background)
            binding.organizationHeading.setTextColor(resources.getColor(R.color.white))
            binding.organizationSubheading.setTextColor(resources.getColor(R.color.subheading_objective_select_color))
            binding.jobseekerLayout.setBackgroundResource(R.drawable.edittext_background)
            binding.jobseekerHeading.setTextColor(resources.getColor(R.color.headingColor))
            binding.jobseekerSubheading.setTextColor(resources.getColor(R.color.edittexthintcolor))
            binding.getStartedBtn.visibility = View.VISIBLE
            binding.getStartedBtn.setOnClickListener(View.OnClickListener {
                navigateToActivity(OrganizationMainActivity())
            })
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