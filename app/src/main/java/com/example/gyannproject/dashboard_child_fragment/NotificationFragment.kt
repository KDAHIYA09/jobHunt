package com.example.gyannproject.dashboard_child_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.dashboard_child_fragment.adapters.Wallet_Activity_adapteer
import com.example.gyannproject.dashboard_child_fragment.dataclasses.Wallet_Acivity_dataclass

class NotificationFragment : Fragment() {

    companion object {
        @JvmStatic
        fun dashboardNotificationInstance() =  NotificationFragment()

    }

    lateinit var notificationRecyclerView : RecyclerView
    lateinit var notificationList: ArrayList<Wallet_Acivity_dataclass>
    lateinit var notificationAdapter : Wallet_Activity_adapteer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        notificationRecyclerView = view.findViewById(R.id.notificatonrv)
        notificationRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        notificationRecyclerView.setHasFixedSize(true)
        notificationList = arrayListOf<Wallet_Acivity_dataclass>()
        getActivityData()
        notificationAdapter = Wallet_Activity_adapteer(notificationList)
        notificationRecyclerView.adapter = notificationAdapter


        super.onViewCreated(view, savedInstanceState)
    }

    private fun getActivityData() {
        notificationList.clear()

        notificationList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", R.drawable.trash_04))
        notificationList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", R.drawable.trash_04))
        notificationList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", R.drawable.trash_04))
        notificationList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", R.drawable.trash_04))
    }

}