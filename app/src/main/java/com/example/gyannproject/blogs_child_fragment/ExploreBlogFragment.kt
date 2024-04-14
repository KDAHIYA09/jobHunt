package com.example.gyannproject.blogs_child_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gyannproject.R
import com.example.gyannproject.jobseeker.adpaters.NewBlogssAdapter
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.jobseeker.fragment.BlogFragment2


class ExploreBlogFragment : Fragment() {

    companion object {
        @JvmStatic
        fun exploreblogInstance() =  ExploreBlogFragment()

    }

    lateinit var newexploreblogRecyclerView : RecyclerView
    lateinit var newexploreblogList: ArrayList<NewBlogsDataClass>
    lateinit var newexploreblogAdapter : NewBlogssAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore_blog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newexploreblogRecyclerView = view.findViewById(R.id.recyclerViewchildblogexplore)
        newexploreblogRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newexploreblogRecyclerView.setHasFixedSize(true)
        newexploreblogList = arrayListOf<NewBlogsDataClass>()
        getBlogData()
        newexploreblogAdapter = NewBlogssAdapter(newexploreblogList)
        newexploreblogRecyclerView.adapter = newexploreblogAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        newexploreblogList.clear()

        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
        newexploreblogList.add(
            NewBlogsDataClass(
                R.drawable.new_blog,
                "Design Principles",
                "Technology",
                "How to build best products",
                "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...",
                R.drawable.save_bookmark
            )
        )
    }



}