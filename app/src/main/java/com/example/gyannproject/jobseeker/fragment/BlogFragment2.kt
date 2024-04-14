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
import com.example.gyannproject.jobseeker.jobs_childFragments.AppliedJobsFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.JobsChildFragment
import com.example.gyannproject.jobseeker.jobs_childFragments.SavedJobFragment


class BlogFragment2 : Fragment() {

    companion object {
        @JvmStatic
        fun blogInstance() =  BlogFragment2()

    }

    private var blogFragmentexplore: ExploreBlogFragment? = null
    private var blogsFragmentsaved: SavedBlogsFragment? = null
    private var activeFragment: Fragment? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        blogFragmentexplore = ExploreBlogFragment.exploreblogInstance()
        blogsFragmentsaved = SavedBlogsFragment.savedblogInstance()
        activeFragment = blogFragmentexplore

        getChildFragmentManager().beginTransaction().apply {
            //add other fragment above
            add(R.id.child_frame_layout_blogs, blogsFragmentsaved!!).hide(blogsFragmentsaved!!)
            add(R.id.child_frame_layout_blogs, blogFragmentexplore!!).show(blogFragmentexplore!!)
        }.commit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blog2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val exploreblog = view.findViewById<TextView>(R.id.blogs_explorer)
        val savedblog = view.findViewById<TextView>(R.id.blogs_saved)
        val exploreheading = view.findViewById<TextView>(R.id.heading_blogs_type)
        val exploredescription = view.findViewById<TextView>(R.id.blogs_type_description)

        exploreblog.setOnClickListener(View.OnClickListener {

            exploreblog.setBackgroundResource(R.drawable.edittext_background)
            savedblog.setBackgroundResource(0)
            exploreheading.text = "Explore Blog"
            exploredescription.text = "Get the best knowledge"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(blogFragmentexplore!!).commit()
            activeFragment = blogFragmentexplore
            blogFragmentexplore!!.onResume()
        })


        savedblog.setOnClickListener(View.OnClickListener {

            exploreblog.setBackgroundResource(0)
            savedblog.setBackgroundResource(R.drawable.edittext_background)
            exploreheading.text = "Saved Blog"
            exploredescription.text = "Find your saved resources here"
            getChildFragmentManager().beginTransaction().hide(activeFragment!!)
                .show(blogsFragmentsaved!!).commit()
            activeFragment = blogsFragmentsaved
            blogsFragmentsaved!!.onResume()
        })

        super.onViewCreated(view, savedInstanceState)
    }

}