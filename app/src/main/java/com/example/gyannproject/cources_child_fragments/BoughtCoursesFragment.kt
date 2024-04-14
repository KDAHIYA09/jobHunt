package com.example.gyannproject.cources_child_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewCoursesAdapter
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass

class BoughtCoursesFragment : Fragment() {

    companion object {
        @JvmStatic
        fun boughtCoursesInstance() =  BoughtCoursesFragment()

    }

    lateinit var newboughtCourseRecyclerView : RecyclerView
    lateinit var newboughtCourseList: ArrayList<NewCoursesDataClass>
    lateinit var newboughtCourseAdapter : NewCoursesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bought_courses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        newboughtCourseRecyclerView = view.findViewById(R.id.recyclerViewchildboughtCourses)
        newboughtCourseRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newboughtCourseRecyclerView.setHasFixedSize(true)
        newboughtCourseList = arrayListOf<NewCoursesDataClass>()
        getBlogData()
        newboughtCourseAdapter = NewCoursesAdapter(newboughtCourseList)
        newboughtCourseRecyclerView.adapter = newboughtCourseAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        newboughtCourseList.clear()

        newboughtCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "Bought", R.drawable.saved_job))
        newboughtCourseList.add(NewCoursesDataClass(R.drawable.wedev, "Web Development", "12 lessons", "  4.4 | 2301 learners", "Bought", R.drawable.save_bookmark))


    }

}