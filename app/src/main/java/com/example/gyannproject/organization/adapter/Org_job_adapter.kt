package com.example.gyannproject.organization.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass
import com.example.gyannproject.organization.DataClass.OrgJobsDataClass
import java.util.ArrayList

class Org_job_adapter (private val newBlogList : ArrayList<OrgJobsDataClass>) : RecyclerView.Adapter<Org_job_adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_org_job, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newBlogList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newBlogList[position]
        holder.post.setText(currentItem.post)
        holder.applicant.setText(currentItem.applicant)
        holder.shaortlist.setText(currentItem.shaortlist)
        holder.date.setText(currentItem.date)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val post : TextView = itemview.findViewById(R.id.post)
        val applicant : TextView = itemview.findViewById(R.id.applicant_no)
        val shaortlist : TextView = itemview.findViewById(R.id.shortlist)
        val date : TextView = itemview.findViewById(R.id.date)
    }


}

