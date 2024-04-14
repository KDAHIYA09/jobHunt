package com.example.gyannproject.organization.childFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import com.example.gyannproject.R

class dashboardHelpOrgFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = dashboardHelpOrgFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_help_org, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dropdownlayout1 = view.findViewById<RelativeLayout>(R.id.faq1drop)
        val dropdownlayout2 = view.findViewById<RelativeLayout>(R.id.faq2drop)
        val dropdownlayout3 = view.findViewById<RelativeLayout>(R.id.faq3drop)
        val dropdownlayout4 = view.findViewById<RelativeLayout>(R.id.faq4drop)

        dropdownlayout1.setOnClickListener(View.OnClickListener {
            val up = view.findViewById<ImageView>(R.id.faq1dropup)
            val down = view.findViewById<ImageView>(R.id.faq1dropdown)
            val ans = view.findViewById<TextView>(R.id.ans1)

            manageDropdown(up, down, ans)

        })

        dropdownlayout2.setOnClickListener(View.OnClickListener {
            val up = view.findViewById<ImageView>(R.id.faq2dropup)
            val down = view.findViewById<ImageView>(R.id.faq2dropdown)
            val ans = view.findViewById<TextView>(R.id.ans2)

            manageDropdown(up, down, ans)

        })

        dropdownlayout3.setOnClickListener(View.OnClickListener {
            val up = view.findViewById<ImageView>(R.id.faq3dropup)
            val down = view.findViewById<ImageView>(R.id.faq3dropdown)
            val ans = view.findViewById<TextView>(R.id.ans3)

            manageDropdown(up, down, ans)

        })

        dropdownlayout4.setOnClickListener(View.OnClickListener {
            val up = view.findViewById<ImageView>(R.id.faq4dropup)
            val down = view.findViewById<ImageView>(R.id.faq4dropdown)
            val ans = view.findViewById<TextView>(R.id.ans4)

            manageDropdown(up, down, ans)

        })

        val btn = view.findViewById<Button>(R.id.submitQuery)
        val query = view.findViewById<EditText>(R.id.userQueryHelp)
        val queryerror = view.findViewById<TextView>(R.id.queryError)

        super.onViewCreated(view, savedInstanceState)
    }

    fun manageDropdown(up: ImageView, down: ImageView, submenu: TextView){
        up.isVisible = !up.isVisible
        down.isVisible = !down.isVisible

        // Check the current visibility state
        val newVisibility = if (submenu.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }

        // Set the new visibility state
        submenu.visibility = newVisibility

        //submenulayout.isVisible = !submenulayout.isVisible
    }

}