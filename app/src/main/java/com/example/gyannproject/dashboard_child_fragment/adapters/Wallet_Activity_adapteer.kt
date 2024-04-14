package com.example.gyannproject.dashboard_child_fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Wallet_Acivity_dataclass
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import java.util.ArrayList

class Wallet_Activity_adapteer (private val activityList : ArrayList<Wallet_Acivity_dataclass>) : RecyclerView.Adapter<Wallet_Activity_adapteer.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_rv_wallet, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = activityList[position]
        holder.activityTitle.setText(currentItem.activityTitle)
        holder.activityDate.setText(currentItem.activityDate)
        holder.delete.setImageResource(currentItem.delete)
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val activityTitle : TextView = itemview.findViewById(R.id.activity_heading)
        val activityDate : TextView = itemview.findViewById(R.id.activity_date)
        val delete : ImageView = itemview.findViewById(R.id.delete)
    }


}

