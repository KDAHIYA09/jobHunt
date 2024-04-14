package com.example.gyannproject.jobseeker.jobs_childFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewJobsAdapter
import com.example.gyannproject.jobseeker.dataclass.NewJobsDataClass
import com.example.gyannproject.jobseeker.fragment.JobsFragment2

class JobsChildFragment : Fragment() {

    companion object {
        @JvmStatic
        fun exploreInstance() =  JobsChildFragment()

    }


    lateinit var newJobRecyclerView : RecyclerView
    lateinit var newjobList: ArrayList<NewJobsDataClass>
    lateinit var newjobAdapter : NewJobsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jobs_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newJobRecyclerView = view.findViewById(R.id.recyclerViewchildJobs)
        newJobRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newJobRecyclerView.setHasFixedSize(true)
        newjobList = arrayListOf<NewJobsDataClass>()
        getJobsData()
        newjobAdapter = NewJobsAdapter(newjobList)
        newJobRecyclerView.adapter = newjobAdapter

        super.onViewCreated(view, savedInstanceState)
    }


    private fun getJobsData() {
        newjobList.clear()

        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
    }


}