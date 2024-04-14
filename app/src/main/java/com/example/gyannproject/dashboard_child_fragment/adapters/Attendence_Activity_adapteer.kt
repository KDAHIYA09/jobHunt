package com.example.gyannproject.dashboard_child_fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Attendence_Acivity_dataclass
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Wallet_Acivity_dataclass
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import java.util.ArrayList

class Attendence_Activity_adapteer (private val activityList : ArrayList<Attendence_Acivity_dataclass>) : RecyclerView.Adapter<Attendence_Activity_adapteer.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_attendence, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = activityList[position]
        holder.date.setText(currentItem.date)
        holder.no_of_video.setText(currentItem.no_of_video)
        holder.durationn.setText(currentItem.durationn)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val date : TextView = itemview.findViewById(R.id.attendence_date)
        val no_of_video : TextView = itemview.findViewById(R.id.attendence_video_no)
        val durationn : TextView = itemview.findViewById(R.id.attendence_duration)
    }


}

