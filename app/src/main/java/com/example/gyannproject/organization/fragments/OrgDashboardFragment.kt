package com.example.gyannproject.organization.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gyannproject.R
import com.example.gyannproject.dashboard_child_fragment.AttendenceFragment
import com.example.gyannproject.dashboard_child_fragment.NotificationFragment
import com.example.gyannproject.organization.childFragment.dashboardHelpOrgFragment
import com.example.gyannproject.organization.childFragment.dashboardProfileOrgFragment

class OrgDashboardFragment : Fragment() {

    companion object {
        @JvmStatic
        fun orgDashboardInstance() = OrgDashboardFragment()
    }

    private var dashboardorgProfileFragment: dashboardProfileOrgFragment? = null
    private var dashboardorgHelpFragment: dashboardHelpOrgFragment? = null
    private var activeFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dashboardorgProfileFragment = dashboardProfileOrgFragment.newInstance()
        dashboardorgHelpFragment = dashboardHelpOrgFragment.newInstance()
        activeFragment = dashboardorgProfileFragment

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.dashboardorg_child_fragments, dashboardorgHelpFragment!!).hide(dashboardorgHelpFragment!!)
            add(R.id.dashboardorg_child_fragments, dashboardorgProfileFragment!!).show(dashboardorgProfileFragment!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_org_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val profile = view.findViewById<TextView>(R.id.dashboard_profile_org)
        val help = view.findViewById<TextView>(R.id.dashboard_help_org)

        profile.setOnClickListener(View.OnClickListener {
            profile.setBackgroundResource(R.drawable.edittext_background)
            help.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardorgProfileFragment!!).commit()
            activeFragment = dashboardorgProfileFragment
            dashboardorgProfileFragment!!.onResume()
        })

        help.setOnClickListener(View.OnClickListener {
            help.setBackgroundResource(R.drawable.edittext_background)
            profile.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardorgHelpFragment!!).commit()
            activeFragment = dashboardorgHelpFragment
            dashboardorgHelpFragment!!.onResume()
        })


        super.onViewCreated(view, savedInstanceState)
    }



}