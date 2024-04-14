package com.example.gyannproject.organization.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.jobs_childFragments.AppliedJobsFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.JobsChildFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.SavedJobFragment
import com.example.gyannproject.organization.childFragment.jobArchievedFragment
import com.example.gyannproject.organization.childFragment.jobOngoingFragment

class OrgJobsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun orgJobInstance() = OrgJobsFragment()
    }

    private var jobsongoing: jobOngoingFragment? = null
    private var jobsarchieved: jobArchievedFragment? = null
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jobsongoing = jobOngoingFragment.jobOngoingInstance()
        jobsarchieved = jobArchievedFragment.jobArchievedInstance()
        activeFragment = jobsongoing

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.child_frame_layout_jobsPosted, jobsarchieved!!).hide(jobsarchieved!!)
            add(R.id.child_frame_layout_jobsPosted, jobsongoing!!).show(jobsongoing!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_org_jobs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val ongoingJob = view.findViewById<TextView>(R.id.jobs_ongoing)
        val archieveJob = view.findViewById<TextView>(R.id.jobs_archieved)
        val jobtypeheading = view.findViewById<TextView>(R.id.heading_jobPost)
        val jobtypedescription = view.findViewById<TextView>(R.id.description_jobPost)

        ongoingJob.setOnClickListener(View.OnClickListener {

            ongoingJob.setBackgroundResource(R.drawable.edittext_background)
            archieveJob.setBackgroundResource(0)
            jobtypeheading.text = "Ongoing jobs"
            jobtypedescription.text = "posted by you"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(jobsongoing!!).commit()
            activeFragment = jobsongoing
            jobsongoing!!.onResume()
        })

        archieveJob.setOnClickListener(View.OnClickListener {

            ongoingJob.setBackgroundResource(0)
            archieveJob.setBackgroundResource(R.drawable.edittext_background)
            jobtypeheading.text = "Archived Jobs"
            jobtypedescription.text = "posted by you"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(jobsarchieved!!).commit()
            activeFragment = jobsarchieved
            jobsarchieved!!.onResume()
        })

        super.onViewCreated(view, savedInstanceState)
    }

}