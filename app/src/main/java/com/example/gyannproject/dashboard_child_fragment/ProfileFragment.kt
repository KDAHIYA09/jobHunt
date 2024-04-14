package com.example.gyannproject.dashboard_child_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gyannproject.R
import com.example.gyannproject.blogs_child_fragment.ExploreBlogFragment

class ProfileFragment : Fragment() {

    companion object {
        @JvmStatic
        fun dashboardProfileInstance() =  ProfileFragment()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

}