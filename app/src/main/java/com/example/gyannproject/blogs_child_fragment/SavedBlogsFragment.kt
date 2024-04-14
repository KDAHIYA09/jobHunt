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
import com.example.gyannproject.jobseeker.adpaters.NewJobsAdapter
import com.example.gyannproject.jobseeker.dataclass.NewBlogsDataClass
import com.example.gyannproject.jobseeker.dataclass.NewJobsDataClass


class SavedBlogsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun savedblogInstance() =  SavedBlogsFragment()

    }

    lateinit var newsavedblogRecyclerView : RecyclerView
    lateinit var newsavedblogList: ArrayList<NewBlogsDataClass>
    lateinit var newsavedblogAdapter : NewBlogssAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_blogs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        newsavedblogRecyclerView = view.findViewById(R.id.recyclerViewchildBlogsSaved)
        newsavedblogRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsavedblogRecyclerView.setHasFixedSize(true)
        newsavedblogList = arrayListOf<NewBlogsDataClass>()
        getBlogData()
        newsavedblogAdapter = NewBlogssAdapter(newsavedblogList)
        newsavedblogRecyclerView.adapter = newsavedblogAdapter


        super.onViewCreated(view, savedInstanceState)
    }


    private fun getBlogData() {
        newsavedblogList.clear()

        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
        newsavedblogList.add(NewBlogsDataClass(R.drawable.new_blog, "Design Principles", "Technology", "How to build best products", "Lorem ipsum dolor sit amet, consectetur adip isci ng eli t, sed do eiusm od tem por incid...", R.drawable.saved_job))
    }


}