package com.example.gyannproject.organization

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityOrganizationMainBinding
import com.example.gyannproject.jobseeker.fragment.BlankFragment
import com.example.gyannproject.jobseeker.fragment.BlogFragment2
import com.example.gyannproject.jobseeker.fragment.CoursesFragment2
import com.example.gyannproject.jobseeker.fragment.DashboardFragment2
import com.example.gyannproject.jobseeker.fragment.JobsFragment2
import com.example.gyannproject.organization.fragments.AiCeoFragment
import com.example.gyannproject.organization.fragments.OrgDashboardFragment
import com.example.gyannproject.organization.fragments.OrgHomeFragment
import com.example.gyannproject.organization.fragments.OrgJobsFragment

class OrganizationMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrganizationMainBinding
    private var orgHomeFragment: OrgHomeFragment? = null
    private var orgJobsFragment: OrgJobsFragment? = null
    private var orgAiCEogFragment: AiCeoFragment? = null
    private var orgDashboardFragment: OrgDashboardFragment? = null
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOrganizationMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        orgDashboardFragment = OrgDashboardFragment.orgDashboardInstance()
        orgAiCEogFragment = AiCeoFragment.aiCeoInstance()
        orgHomeFragment = OrgHomeFragment.orgHomeInstance()
        orgJobsFragment = OrgJobsFragment.orgJobInstance()

        activeFragment = orgHomeFragment

        supportFragmentManager.beginTransaction().apply {
            //add other fragment above
            add(R.id.fragment_container_org, orgDashboardFragment!!).hide(orgDashboardFragment!!)
            add(R.id.fragment_container_org, orgAiCEogFragment!!).hide(orgAiCEogFragment!!)
            add(R.id.fragment_container_org, orgJobsFragment!!).hide(orgJobsFragment!!)
            add(R.id.fragment_container_org, orgHomeFragment!!).show(orgHomeFragment!!)
        }.commit()

        val drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutOrg,
            R.string.open_nav,
            R.string.close_nav
        )
        binding.drawerLayoutOrg.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.bottomNavMenuOrg.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_home -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(orgHomeFragment!!).commit()
                    activeFragment = orgHomeFragment
                    orgHomeFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_jobs -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(orgJobsFragment!!).commit()
                    activeFragment = orgJobsFragment
                    orgJobsFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_ai -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(orgAiCEogFragment!!).commit()
                    activeFragment = orgAiCEogFragment
                    orgAiCEogFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_dashboard -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(orgDashboardFragment!!).commit()
                    activeFragment = orgDashboardFragment
                    orgDashboardFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                // Add more cases for additional bottom navigation items if needed
                else -> return@setOnItemSelectedListener true
            }
        }


        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when(activeFragment){
                    orgDashboardFragment,orgAiCEogFragment,orgJobsFragment -> {
                        supportFragmentManager.beginTransaction().hide(activeFragment!!)
                            .show(orgHomeFragment!!).commit()
                        activeFragment = orgHomeFragment
                        orgHomeFragment!!.onResume()
                    }

                    else -> {
                        finishAfterTransition()
                    }


                }
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)


    }
}