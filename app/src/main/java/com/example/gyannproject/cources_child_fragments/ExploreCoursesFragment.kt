package com.example.gyannproject.cources_child_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewCoursesAdapter
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass


class ExploreCoursesFragment : Fragment() {

    companion object {
        @JvmStatic
        fun exploreCoursesInstance() =  ExploreCoursesFragment()

    }

    lateinit var newexploreCourseRecyclerView : RecyclerView
    lateinit var newexploreCourseList: ArrayList<NewCoursesDataClass>
    lateinit var newexploreCourseAdapter : NewCoursesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newexploreCourseRecyclerView = view.findViewById(R.id.recyclerViewchildexploreCourses)
        newexploreCourseRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newexploreCourseRecyclerView.setHasFixedSize(true)
        newexploreCourseList = arrayListOf<NewCoursesDataClass>()
        getBlogData()
        newexploreCourseAdapter = NewCoursesAdapter(newexploreCourseList)
        newexploreCourseRecyclerView.adapter = newexploreCourseAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        newexploreCourseList.clear()

        newexploreCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "Free", R.drawable.save_bookmark))
        newexploreCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "128 GC", R.drawable.save_bookmark))


    }

}