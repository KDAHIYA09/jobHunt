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

class jobOngoingFragment : Fragment() {
    companion object {
        @JvmStatic
        fun jobOngoingInstance() = jobOngoingFragment()
    }

    lateinit var jobOngingRecyclerView : RecyclerView
    lateinit var jobOngingList: ArrayList<OrgJobsDataClass>
    lateinit var jobOngingAdapter : Org_job_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_job_ongoing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        jobOngingRecyclerView = view.findViewById(R.id.ongoingJobRV)
        jobOngingRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        jobOngingRecyclerView.setHasFixedSize(true)
        jobOngingList = arrayListOf<OrgJobsDataClass>()
        getBlogData()
        jobOngingAdapter = Org_job_adapter(jobOngingList)
        jobOngingRecyclerView.adapter = jobOngingAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        jobOngingList.clear()

        jobOngingList.add(
            OrgJobsDataClass(
                "Sr. UX Designer",
                "302 applications",
                "23 Shortlisted",
                "12/03/24"
            )
        )

        jobOngingList.add(
            OrgJobsDataClass(
                "Sr. UX Designer",
                "302 applications",
                "23 Shortlisted",
                "12/03/24"
            )
        )
    }


}