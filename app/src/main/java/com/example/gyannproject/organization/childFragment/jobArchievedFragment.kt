package com.example.gyannproject.organization.childFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewBlogssAdapter
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.organization.DataClass.OrgJobsDataClass
import com.example.gyannproject.organization.adapter.Org_job_adapter

class jobArchievedFragment : Fragment() {
    companion object {
        @JvmStatic
        fun jobArchievedInstance() = jobArchievedFragment()
    }

    lateinit var jobArchievedRecyclerView : RecyclerView
    lateinit var jobArchievedList: ArrayList<OrgJobsDataClass>
    lateinit var jobArchievedAdapter : Org_job_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_archieved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        jobArchievedRecyclerView = view.findViewById(R.id.archievedJobRV)
        jobArchievedRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        jobArchievedRecyclerView.setHasFixedSize(true)
        jobArchievedList = arrayListOf<OrgJobsDataClass>()
        getBlogData()
        jobArchievedAdapter = Org_job_adapter(jobArchievedList)
        jobArchievedRecyclerView.adapter = jobArchievedAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        jobArchievedList.clear()

        jobArchievedList.add(
            OrgJobsDataClass(
                "Sr. UX Designer",
                "302 applications",
                "23 Shortlisted",
                "12/03/24"
            )
        )

        jobArchievedList.add(
            OrgJobsDataClass(
                "Sr. UX Designer",
                "302 applications",
                "23 Shortlisted",
                "12/03/24"
            )
        )
    }


}