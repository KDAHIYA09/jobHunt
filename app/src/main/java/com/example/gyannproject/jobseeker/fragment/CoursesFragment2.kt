package com.example.gyannproject.jobseeker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gyannproject.R
import com.example.gyannproject.cources_child_fragments.BoughtCoursesFragment
import com.example.gyannproject.cources_child_fragments.ExploreCoursesFragment
import com.example.gyannproject.cources_child_fragments.SavedCoursesFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.AppliedJobsFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.JobsChildFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.SavedJobFragment

class CoursesFragment2 : Fragment() {

    companion object {
        @JvmStatic
        fun courseInstance() =  CoursesFragment2()

    }

    private var coursesFragmentexplore: ExploreCoursesFragment? = null
    private var coursesFragmentbought: BoughtCoursesFragment? = null
    private var coursesFragmentsaved: SavedCoursesFragment? = null
    private var activeFragment: Fragment? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coursesFragmentexplore = ExploreCoursesFragment.exploreCoursesInstance()
        coursesFragmentbought = BoughtCoursesFragment.boughtCoursesInstance()
        coursesFragmentsaved = SavedCoursesFragment.savedCoursesInstance()
        activeFragment = coursesFragmentexplore

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.child_frame_layout_courses, coursesFragmentsaved!!).hide(coursesFragmentsaved!!)
            add(R.id.child_frame_layout_courses, coursesFragmentbought!!).hide(coursesFragmentbought!!)
            add(R.id.child_frame_layout_courses, coursesFragmentexplore!!).show(coursesFragmentexplore!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val boughtCourse = view.findViewById<TextView>(R.id.courses_Bought)
        val exploreCourse = view.findViewById<TextView>(R.id.courses_explorer)
        val savedCourse = view.findViewById<TextView>(R.id.savedCourse)
        val coursetypeheading = view.findViewById<TextView>(R.id.heading_courses_type)
        val coursetypedescription = view.findViewById<TextView>(R.id.courses_type_description)

        exploreCourse.setOnClickListener(View.OnClickListener {
            exploreCourse.setBackgroundResource(R.drawable.edittext_background)
            boughtCourse.setBackgroundResource(0)
            savedCourse.setBackgroundResource(0)
            coursetypeheading.text = "Trending"
            coursetypedescription.text = "Top picks for you"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(coursesFragmentexplore!!).commit()
            activeFragment = coursesFragmentexplore
            coursesFragmentexplore!!.onResume()
        })

        boughtCourse.setOnClickListener(View.OnClickListener {

            exploreCourse.setBackgroundResource(0)
            boughtCourse.setBackgroundResource(R.drawable.edittext_background)
            savedCourse.setBackgroundResource(0)
            coursetypeheading.text = "Applied Jobs"
            coursetypedescription.text = "Find your application status here"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(coursesFragmentbought!!).commit()
            activeFragment = coursesFragmentbought
            coursesFragmentbought!!.onResume()
        })

        savedCourse.setOnClickListener(View.OnClickListener {

            exploreCourse.setBackgroundResource(0)
            boughtCourse.setBackgroundResource(0)
            savedCourse.setBackgroundResource(R.drawable.edittext_background)
            coursetypeheading.text = "Bought"
            coursetypedescription.text = "courses purchased by you"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(coursesFragmentsaved!!).commit()
            activeFragment = coursesFragmentsaved
            coursesFragmentsaved!!.onResume()
        })

        super.onViewCreated(view, savedInstanceState)
    }

}