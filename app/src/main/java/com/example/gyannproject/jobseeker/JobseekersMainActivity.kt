package com.example.gyannproject.jobseeker

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.gyannproject.R
import com.example.gyannproject.databinding.ActivityJobseekersMainBinding
import com.example.gyannproject.jobseeker.fragment.BlankFragment
import com.example.gyannproject.jobseeker.fragment.BlogFragment2
import com.example.gyannproject.jobseeker.fragment.DashboardFragment2
import com.example.gyannproject.jobseeker.fragment.CoursesFragment2
import com.example.gyannproject.jobseeker.fragment.JobsFragment2

class JobseekersMainActivity : AppCompatActivity() {

    lateinit var binding : ActivityJobseekersMainBinding
    private var courseFragment: CoursesFragment2? = null
    private var jobsFragment: JobsFragment2? = null
    private var blogFragment: BlogFragment2? = null
    private var homeFragment: BlankFragment? = null
    private var dashboardFragment: DashboardFragment2? = null
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityJobseekersMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        courseFragment = CoursesFragment2.courseInstance()
        jobsFragment = JobsFragment2.jobInstance()
        blogFragment = BlogFragment2.blogInstance()
        homeFragment = BlankFragment.homeInstance()
        dashboardFragment = DashboardFragment2.dashboardInstance()

        activeFragment = homeFragment

        supportFragmentManager.beginTransaction().apply {
            //add other fragment above
            add(R.id.fragment_container, dashboardFragment!!).hide(dashboardFragment!!)
            add(R.id.fragment_container, blogFragment!!).hide(blogFragment!!)
            add(R.id.fragment_container, jobsFragment!!).hide(jobsFragment!!)
            add(R.id.fragment_container, courseFragment!!).hide(courseFragment!!)
            add(R.id.fragment_container, homeFragment!!).show(homeFragment!!)
        }.commit()

        val drawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_nav,
            R.string.close_nav
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Set OnClickListener on the menu icon
        binding.sidemenu.setOnClickListener { openSideMenu() }

        binding.bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_one -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(courseFragment!!).commit()
                    activeFragment = courseFragment
                    courseFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_two -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(jobsFragment!!).commit()
                    activeFragment = jobsFragment
                    jobsFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_three -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(homeFragment!!).commit()
                    activeFragment = homeFragment
                    homeFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_four -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(blogFragment!!).commit()
                    activeFragment = blogFragment
                    blogFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_five -> {
                    //loadFragment(HoomeFragment())
                    supportFragmentManager.beginTransaction().hide(activeFragment!!)
                        .show(dashboardFragment!!).commit()
                    activeFragment = dashboardFragment
                    dashboardFragment!!.onResume()
                    return@setOnItemSelectedListener true
                }
                // Add more cases for additional bottom navigation items if needed
                else -> return@setOnItemSelectedListener true
            }
        }
        binding.bottomNavMenu.setSelectedItemId(R.id.bottom_three)
        binding.navigationView.findViewById<ImageView>(R.id.closeDrawer).setOnClickListener(View.OnClickListener {
            closeSideMenu()
        })

        //for custom menu
        val menu = binding.navigationView.findViewById<ConstraintLayout>(R.id.custom_menu_two)
        //dropdown
        val dropdownlayoutcourses = menu.findViewById<RelativeLayout>(R.id.dropdownlayoutcourses)
        val dropdownlayoutjobs = menu.findViewById<RelativeLayout>(R.id.dropdownlayoutjobs)
        val dropdownlayoutblogs = menu.findViewById<RelativeLayout>(R.id.dropdownlayoutblogs)
        val dropdownlayoutsaved = menu.findViewById<RelativeLayout>(R.id.dropdownlayoutsaved)
        val dropdownlayoutdashboard = menu.findViewById<RelativeLayout>(R.id.dropdownlayoutdashboard)

        //for courses submenu
        dropdownlayoutcourses.setOnClickListener(View.OnClickListener {
            val up = menu.findViewById<ImageView>(R.id.deals_arrowup1)
            val down = menu.findViewById<ImageView>(R.id.deals_arrowdown2)
            val subMenu = menu.findViewById<LinearLayout>(R.id.submenuItem_courses)

            manageDropdown(up, down, subMenu)

        })
        //for jobs submenu
        dropdownlayoutjobs.setOnClickListener(View.OnClickListener {
            val up = menu.findViewById<ImageView>(R.id.deals_arrow1)
            val down = menu.findViewById<ImageView>(R.id.deals_arrow2)
            val subMenu = menu.findViewById<LinearLayout>(R.id.submenuItem_jobs)

            manageDropdown(up, down, subMenu)

        })
        //for blogs submenu
        dropdownlayoutblogs.setOnClickListener(View.OnClickListener {
            val up = menu.findViewById<ImageView>(R.id.deals_arrowdownup3)
            val down = menu.findViewById<ImageView>(R.id.deals_arrowdown3)
            val subMenu = menu.findViewById<LinearLayout>(R.id.submenuItem_blogs)

            manageDropdown(up, down, subMenu)

        })
        //for saved submenu
        dropdownlayoutsaved.setOnClickListener(View.OnClickListener {
            val up = menu.findViewById<ImageView>(R.id.deals_arrowup5)
            val down = menu.findViewById<ImageView>(R.id.deals_arrowdown5)
            val subMenu = menu.findViewById<LinearLayout>(R.id.submenuItem_saved)

            manageDropdown(up, down, subMenu)

        })
        //for dashboard submenu
        dropdownlayoutdashboard.setOnClickListener(View.OnClickListener {
            val up = menu.findViewById<ImageView>(R.id.deals_arrowup6)
            val down = menu.findViewById<ImageView>(R.id.deals_arrowdown6)
            val subMenu = menu.findViewById<LinearLayout>(R.id.submenuItem_dashboard)

            manageDropdown(up, down, subMenu)

        })





        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                when(activeFragment){
                    courseFragment,jobsFragment,dashboardFragment,blogFragment -> {
                        supportFragmentManager.beginTransaction().hide(activeFragment!!)
                            .show(homeFragment!!).commit()
                        activeFragment = homeFragment
                        homeFragment!!.onResume()
                        binding.bottomNavMenu.selectedItemId = R.id.bottom_three
                    }

                    else -> {
                        finishAfterTransition()
                    }


                }
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)


    }

    fun manageDropdown(up: ImageView, down: ImageView, submenu: LinearLayout){
        up.isVisible = !up.isVisible
        down.isVisible = !down.isVisible

        // Check the current visibility state
        val newVisibility = if (submenu.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }

        // Set the new visibility state
        submenu.visibility = newVisibility

        //submenulayout.isVisible = !submenulayout.isVisible
    }

    private fun openSideMenu() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun closeSideMenu() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onResume() {
        super.onResume()
        //handleBottomNavigation()
    }

    override fun onPause() {
        super.onPause()
        //handleBottomNavigation()
    }

    override fun onDestroy() {
        super.onDestroy()
        courseFragment = null
        jobsFragment = null
        blogFragment = null
        dashboardFragment = null
        homeFragment = null
    }




}




