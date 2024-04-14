package com.example.gyannproject.jobseeker.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gyannproject.R
import com.example.gyannproject.blogs_child_fragment.ExploreBlogFragment
import com.example.gyannproject.blogs_child_fragment.SavedBlogsFragment
import com.example.gyannproject.dashboard_child_fragment.AttendenceFragment
import com.example.gyannproject.dashboard_child_fragment.BadgesFragment
import com.example.gyannproject.dashboard_child_fragment.HelpFragment
import com.example.gyannproject.dashboard_child_fragment.NotificationFragment
import com.example.gyannproject.dashboard_child_fragment.ProfileFragment
import com.example.gyannproject.dashboard_child_fragment.WalletFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.JobsChildFragment

class DashboardFragment2 : Fragment() {

    companion object {
        @JvmStatic
        fun dashboardInstance() =  DashboardFragment2()

    }

    private var dashboardProfileFragment: ProfileFragment? = null
    private var dashboardWalletFragment: WalletFragment? = null
    private var dashboardBadgesFragment: BadgesFragment? = null
    private var dashboardHelpFragment: HelpFragment? = null
    private var dashboardAttendenceFragment: AttendenceFragment? = null
    private var dashboardNotificationFragment: NotificationFragment? = null
    private var activeFragment: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dashboardProfileFragment = ProfileFragment.dashboardProfileInstance()
        dashboardWalletFragment = WalletFragment.dashboardWalletInstance()
        dashboardBadgesFragment = BadgesFragment.dashboardBadgesInstance()
        dashboardHelpFragment = HelpFragment.dashboardHelpInstance()
        dashboardAttendenceFragment = AttendenceFragment.dashboardAttendeceInstance()
        dashboardNotificationFragment = NotificationFragment.dashboardNotificationInstance()
        activeFragment = dashboardProfileFragment

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.dashboardf_child_fragments, dashboardNotificationFragment!!).hide(dashboardNotificationFragment!!)
            add(R.id.dashboardf_child_fragments, dashboardAttendenceFragment!!).hide(dashboardAttendenceFragment!!)
            add(R.id.dashboardf_child_fragments, dashboardHelpFragment!!).hide(dashboardHelpFragment!!)
            add(R.id.dashboardf_child_fragments, dashboardBadgesFragment!!).hide(dashboardBadgesFragment!!)
            add(R.id.dashboardf_child_fragments, dashboardWalletFragment!!).hide(dashboardWalletFragment!!)
            add(R.id.dashboardf_child_fragments, dashboardProfileFragment!!).show(dashboardProfileFragment!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val profile = view.findViewById<TextView>(R.id.dashboard_profile)
        val wallet = view.findViewById<TextView>(R.id.dashboard_wallet)
        val badges = view.findViewById<TextView>(R.id.dashboard_badges)
        val help = view.findViewById<TextView>(R.id.dashboard_Help)
        val attendence = view.findViewById<TextView>(R.id.dashboard_Attendence)
        val notification = view.findViewById<TextView>(R.id.dashboard_NOTIFICATION)

        profile.setOnClickListener(View.OnClickListener {
            profile.setBackgroundResource(R.drawable.edittext_background)
            wallet.setBackgroundResource(0)
            badges.setBackgroundResource(0)
            help.setBackgroundResource(0)
            attendence.setBackgroundResource(0)
            notification.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardProfileFragment!!).commit()
            activeFragment = dashboardProfileFragment
            dashboardProfileFragment!!.onResume()
        })

        wallet.setOnClickListener(View.OnClickListener {
            wallet.setBackgroundResource(R.drawable.edittext_background)
            profile.setBackgroundResource(0)
            badges.setBackgroundResource(0)
            help.setBackgroundResource(0)
            attendence.setBackgroundResource(0)
            notification.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardBadgesFragment!!).commit()
            activeFragment = dashboardBadgesFragment
            dashboardBadgesFragment!!.onResume()
        })

        badges.setOnClickListener(View.OnClickListener {
            badges.setBackgroundResource(R.drawable.edittext_background)
            wallet.setBackgroundResource(0)
            profile.setBackgroundResource(0)
            help.setBackgroundResource(0)
            attendence.setBackgroundResource(0)
            notification.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardWalletFragment!!).commit()
            activeFragment = dashboardWalletFragment
            dashboardWalletFragment!!.onResume()
        })

        help.setOnClickListener(View.OnClickListener {
            help.setBackgroundResource(R.drawable.edittext_background)
            wallet.setBackgroundResource(0)
            badges.setBackgroundResource(0)
            profile.setBackgroundResource(0)
            attendence.setBackgroundResource(0)
            notification.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardHelpFragment!!).commit()
            activeFragment = dashboardHelpFragment
            dashboardHelpFragment!!.onResume()
        })

        attendence.setOnClickListener(View.OnClickListener {
            attendence.setBackgroundResource(R.drawable.edittext_background)
            wallet.setBackgroundResource(0)
            badges.setBackgroundResource(0)
            help.setBackgroundResource(0)
            profile.setBackgroundResource(0)
            notification.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardAttendenceFragment!!).commit()
            activeFragment = dashboardAttendenceFragment
            dashboardAttendenceFragment!!.onResume()
        })

        notification.setOnClickListener(View.OnClickListener {
            notification.setBackgroundResource(R.drawable.edittext_background)
            wallet.setBackgroundResource(0)
            badges.setBackgroundResource(0)
            help.setBackgroundResource(0)
            attendence.setBackgroundResource(0)
            profile.setBackgroundResource(0)
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(dashboardNotificationFragment!!).commit()
            activeFragment = dashboardNotificationFragment
            dashboardNotificationFragment!!.onResume()
        })




        super.onViewCreated(view, savedInstanceState)
    }


}