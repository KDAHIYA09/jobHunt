package com.example.gyannproject.jobseeker.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass
import com.example.gyannproject.jobseeker.dataclass.NewJobsDataClass
import java.util.ArrayList

class NewJobsAdapter (private val newJobsList : ArrayList<NewJobsDataClass>) : RecyclerView.Adapter<NewJobsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new_jobs, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newJobsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newJobsList[position]
        holder.jobImage.setImageResource(currentItem.jobImage)
        holder.jobTitle.setText(currentItem.jobTitle)
        holder.jobCompany.setText(currentItem.jobCompany)
        holder.jobLocation.setText(currentItem.jobLocation)
        holder.jobDate.setText(currentItem.jobDate)
        holder.jobsave.setImageResource(currentItem.jobsave)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val jobImage : ImageView = itemview.findViewById(R.id.new_job_iv)
        val jobTitle : TextView = itemview.findViewById(R.id.new_job_name_tv)
        val jobCompany : TextView = itemview.findViewById(R.id.new_job_company)
        val jobLocation : TextView = itemview.findViewById(R.id.new_job_location)
        val jobDate : TextView = itemview.findViewById(R.id.job_posting_date)
        val jobsave : ImageView = itemview.findViewById(R.id.bookmark)
    }


}

