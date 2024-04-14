package com.example.gyannproject.jobseeker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewBlogssAdapter
import com.example.gyannproject.jobseeker.adpaters.NewCoursesAdapter
import com.example.gyannproject.jobseeker.adpaters.NewJobsAdapter
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass
import com.example.gyannproject.jobseeker.dataclass.NewJobsDataClass

class BlankFragment : Fragment() {

    companion object {
        @JvmStatic
        fun homeInstance() =  BlankFragment()

    }

    lateinit var newCoursesRecyclerView : RecyclerView
    lateinit var newCourseList: ArrayList<NewCoursesDataClass>
    lateinit var newCourseAdapter : NewCoursesAdapter
    lateinit var newJobRecyclerView : RecyclerView
    lateinit var newjobList: ArrayList<NewJobsDataClass>
    lateinit var newjobAdapter : NewJobsAdapter
    lateinit var newBlogRecyclerView: RecyclerView
    lateinit var newBlogList: ArrayList<NewBlogsDataClass>
    lateinit var newBlogAdapter: NewBlogssAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newCoursesRecyclerView = view.findViewById(R.id.recyclerViewNewCourse)
        newCoursesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newCoursesRecyclerView.setHasFixedSize(true)
        newCourseList = arrayListOf<NewCoursesDataClass>()
        getCourseData()
        newCourseAdapter = NewCoursesAdapter(newCourseList)
        newCoursesRecyclerView.adapter = newCourseAdapter

        newJobRecyclerView = view.findViewById(R.id.recyclerViewNewJobs)
        newJobRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newJobRecyclerView.setHasFixedSize(true)
        newjobList = arrayListOf<NewJobsDataClass>()
        getJobsData()
        newjobAdapter = NewJobsAdapter(newjobList)
        newJobRecyclerView.adapter = newjobAdapter

        newBlogRecyclerView = view.findViewById(R.id.recyclerViewNewBlogs)
        newBlogRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newBlogRecyclerView.setHasFixedSize(true)
        newBlogList = arrayListOf<NewBlogsDataClass>()
        getBlogData()
        newBlogAdapter = NewBlogssAdapter(newBlogList)
        newBlogRecyclerView.adapter = newBlogAdapter


        super.onViewCreated(view, savedInstanceState)
    }

    private fun getBlogData() {
        newBlogList.clear()

        newBlogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.save_bookmark))
        newBlogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.save_bookmark))
    }

    private fun getJobsData() {
        newjobList.clear()

        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
        newjobList.add(NewJobsDataClass(R.drawable.new_job, "Sr. UX Designer", "Amazon", "Remote(Anywhere)", "12/03/24", R.drawable.save_bookmark))
    }

    private fun getCourseData() {
        newCourseList.clear()

        newCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "Free", R.drawable.save_bookmark))
        newCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "128 GC", R.drawable.save_bookmark))

    }


}