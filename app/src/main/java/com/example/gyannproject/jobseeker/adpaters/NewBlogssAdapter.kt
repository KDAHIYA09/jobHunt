package com.example.gyannproject.jobseeker.adpaters

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

class NewBlogssAdapter (private val newjobPostList : ArrayList<NewBlogsDataClass>) : RecyclerView.Adapter<NewBlogssAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_new_blog, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newjobPostList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newjobPostList[position]
        holder.blogImage.setImageResource(currentItem.blogImage)
        holder.blogGenera1.setText(currentItem.blogGenera1)
        holder.blogGenera2.setText(currentItem.blogGenera2)
        holder.blogHeading.setText(currentItem.blogHeading)
        holder.blogContent.setText(currentItem.blogContent)
        holder.blogSaved.setImageResource(currentItem.blogSaved)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val blogImage : ImageView = itemview.findViewById(R.id.new_blog_image)
        val blogGenera1 : TextView = itemview.findViewById(R.id.blog_genera1)
        val blogGenera2 : TextView = itemview.findViewById(R.id.blog_genera2)
        val blogHeading : TextView = itemview.findViewById(R.id.blog_title)
        val blogContent : TextView = itemview.findViewById(R.id.blog_description)
        val blogSaved : ImageView = itemview.findViewById(R.id.save_blog_bookmark)
    }


}

