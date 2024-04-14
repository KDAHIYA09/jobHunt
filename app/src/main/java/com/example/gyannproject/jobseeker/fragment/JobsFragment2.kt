package com.example.gyannproject.jobseeker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.jobs_childFragments.AppliedJobsFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.JobsChildFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.SavedJobFragment


class JobsFragment2 : Fragment() {


    companion object {
        @JvmStatic
        fun jobInstance() =  JobsFragment2()

    }

    private var jobsFragmentexplore: JobsChildFragment? = null
    private var jobsFragmentAPPLY: AppliedJobsFragment? = null
    private var jobsFragmentsaved: SavedJobFragment? = null
    private var activeFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jobsFragmentexplore = JobsChildFragment.exploreInstance()
        jobsFragmentAPPLY = AppliedJobsFragment.appliedjobInstance()
        jobsFragmentsaved = SavedJobFragment.saveJobInstance()
        activeFragment = jobsFragmentexplore

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.child_frame_layout_jobs, jobsFragmentAPPLY!!).hide(jobsFragmentAPPLY!!)
            add(R.id.child_frame_layout_jobs, jobsFragmentsaved!!).hide(jobsFragmentsaved!!)
            add(R.id.child_frame_layout_jobs, jobsFragmentexplore!!).show(jobsFragmentexplore!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs2, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val appliedJob = view.findViewById<TextView>(R.id.jobs_applying)
        val exploreJob = view.findViewById<TextView>(R.id.jobs_explorer)
        val savedJob = view.findViewById<TextView>(R.id.jobs_saved)
        val jobtypeheading = view.findViewById<TextView>(R.id.heading_job_type)
        val jobtypedescription = view.findViewById<TextView>(R.id.job_type_description)

        exploreJob.setOnClickListener(View.OnClickListener {

            exploreJob.setBackgroundResource(R.drawable.edittext_background)
            appliedJob.setBackgroundResource(0)
            savedJob.setBackgroundResource(0)
            jobtypeheading.text = "Explore Jobs"
            jobtypedescription.text = "Explore jobs from industry companies"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(jobsFragmentexplore!!).commit()
            activeFragment = jobsFragmentexplore
            jobsFragmentexplore!!.onResume()
        })

        appliedJob.setOnClickListener(View.OnClickListener {

            exploreJob.setBackgroundResource(0)
            appliedJob.setBackgroundResource(R.drawable.edittext_background)
            savedJob.setBackgroundResource(0)
            jobtypeheading.text = "Applied Jobs"
            jobtypedescription.text = "Find your application status here"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(jobsFragmentAPPLY!!).commit()
            activeFragment = jobsFragmentAPPLY
            jobsFragmentAPPLY!!.onResume()
        })

        savedJob.setOnClickListener(View.OnClickListener {

            exploreJob.setBackgroundResource(0)
            appliedJob.setBackgroundResource(0)
            savedJob.setBackgroundResource(R.drawable.edittext_background)
            jobtypeheading.text = "Saved Jobs"
            jobtypedescription.text = "Find your saved jobs here"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(jobsFragmentsaved!!).commit()
            activeFragment = jobsFragmentsaved
            jobsFragmentAPPLY!!.onResume()
        })

        super.onViewCreated(view, savedInstanceState)
    }


}