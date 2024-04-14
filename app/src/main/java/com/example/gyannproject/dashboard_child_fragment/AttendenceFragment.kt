package com.example.gyannproject.dashboard_child_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.dashboard_child_fragment.adapters.Attendence_Activity_adapteer
import com.example.gyannproject.dashboard_child_fragment.adapters.Wallet_Activity_adapteer
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Attendence_Acivity_dataclass
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Wallet_Acivity_dataclass

class AttendenceFragment : Fragment() {

    companion object {
        @JvmStatic
        fun dashboardAttendeceInstance() =  AttendenceFragment()

    }

    lateinit var attendenceRecyclerView : RecyclerView
    lateinit var attendenceList: ArrayList<Attendence_Acivity_dataclass>
    lateinit var attendenceAdapter : Attendence_Activity_adapteer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attendence, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        attendenceRecyclerView = view.findViewById(R.id.attendencerv)
        attendenceRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        attendenceRecyclerView.setHasFixedSize(true)
        attendenceList = arrayListOf<Attendence_Acivity_dataclass>()
        getActivityData()
        attendenceAdapter = Attendence_Activity_adapteer(attendenceList)
        attendenceRecyclerView.adapter = attendenceAdapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun getActivityData() {
        attendenceList.clear()

        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
        attendenceList.add(Attendence_Acivity_dataclass("12/02/24", "Videos watched : 2", "Duration : 3hr"))
    }



}