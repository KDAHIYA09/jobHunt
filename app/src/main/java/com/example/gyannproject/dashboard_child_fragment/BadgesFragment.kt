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
import com.example.gyannproject.jobseeker.adpaters.NewCoursesAdapter
import com.example.gyannproject.jobseeker.dataclass.NewCoursesDataClass

class BadgesFragment : Fragment() {

    companion object {
        @JvmStatic
        fun dashboardBadgesInstance() =  BadgesFragment()

    }

    lateinit var walletActivityRecyclerView : RecyclerView
    lateinit var walletActivityList: ArrayList<Wallet_Acivity_dataclass>
    lateinit var walletActivityAdapter : Wallet_Activity_adapteer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_badges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        walletActivityRecyclerView = view.findViewById(R.id.rv_wallet)
        walletActivityRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        walletActivityRecyclerView.setHasFixedSize(true)
        walletActivityList = arrayListOf<Wallet_Acivity_dataclass>()
        getActivityData()
        walletActivityAdapter = Wallet_Activity_adapteer(walletActivityList)
        walletActivityRecyclerView.adapter = walletActivityAdapter


        super.onViewCreated(view, savedInstanceState)
    }

    private fun getActivityData() {
        walletActivityList.clear()

        walletActivityList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", 0))
        walletActivityList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", 0))
        walletActivityList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", 0))
        walletActivityList.add(Wallet_Acivity_dataclass("Purchased course", "12/02/24", 0))
    }

}