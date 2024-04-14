package com.example.gyannproject.cources_child_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.blogs_child_fragment.ExploreBlogFragment
import com.example.gyannproject.jobseeker.adpaters.NewBlogssAdapter
import com.example.gyannproject.jobseeker.adpaters.NewCoursesAdapter
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass

class SavedCoursesFragment : Fragment() {

    companion object {
        @JvmStatic
        fun savedCoursesInstance() =  SavedCoursesFragment()

    }

    lateinit var newsavedCourseRecyclerView : RecyclerView
    lateinit var newsavedCourseList: ArrayList<NewCoursesDataClass>
    lateinit var newsavedCourseAdapter : NewCoursesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newsavedCourseRecyclerView = view.findViewById(R.id.recyclerViewchildsavedCourses)
        newsavedCourseRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsavedCourseRecyclerView.setHasFixedSize(true)
        newsavedCourseList = arrayListOf<NewCoursesDataClass>()
        getBlogData()
        newsavedCourseAdapter = NewCoursesAdapter(newsavedCourseList)
        newsavedCourseRecyclerView.adapter = newsavedCourseAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        newsavedCourseList.clear()

        newsavedCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "Free", R.drawable.saved_job))
        newsavedCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "128 GC", R.drawable.saved_job))


    }

}