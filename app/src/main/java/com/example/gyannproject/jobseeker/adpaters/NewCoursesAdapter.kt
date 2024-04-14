package com.example.gyannproject.jobseeker.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass
import java.util.ArrayList

class NewCoursesAdapter (private val newCourseList : ArrayList<NewCoursesDataClass>) : RecyclerView.Adapter<NewCoursesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new_courses, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newCourseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newCourseList[position]
        holder.courseImage.setImageResource(currentItem.courseImage)
        holder.courseName.setText(currentItem.courseName)
        holder.lessonNo.setText(currentItem.lessonNo)
        holder.courseReview.setText(currentItem.courseReview)
        holder.courseType.setText(currentItem.courseType)
        holder.courseSaved.setImageResource(currentItem.courseSaved)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val courseImage : ImageView = itemview.findViewById(R.id.new_course_iv)
        val courseName : TextView = itemview.findViewById(R.id.new_course_name_tv)
        val lessonNo : TextView = itemview.findViewById(R.id.new_course_no_of_lessons)
        val courseReview : TextView = itemview.findViewById(R.id.new_course_no_of_enrollment)
        val courseType : TextView = itemview.findViewById(R.id.new_course_fees)
        val courseSaved : ImageView = itemview.findViewById(R.id.courseSaved)
    }


}

