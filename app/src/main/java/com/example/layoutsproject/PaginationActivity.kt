package com.example.layoutsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaginationActivity : AppCompatActivity() {

    private val listViewType2 = mutableListOf<Int>()

    private var startPage = 1
    private var isLoading = false
    private val limit = 14

    private lateinit var recyclerView2: RecyclerView
    private lateinit var multiViewRecyclerAdapter: MultiViewRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)

        recyclerView2 = findViewById(R.id.recyclerView2)

        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView2.layoutManager = layoutManager

        getPage()

        recyclerView2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView2: RecyclerView, dx: Int, dy: Int) {

                // dy means vertical scroll position
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                    // use isLastPage to stop when last page shown
                    // to the users
                    if (!isLoading) {
                        if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                            startPage++
                            getPage()
                        }
                    }
                }
                super.onScrolled(recyclerView2, dx, dy)
            }
        })
    }

    private fun getPage() {
        isLoading = true

        // When loading
        // show progressBar
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        // For endless scrolling
        val start = (startPage - 1) * limit
        val end = (startPage) * limit

        for (i in start..end) {
            when {
                i % 2 == 0 -> {
                    listViewType2.add(MultiViewRecyclerAdapter.TEXT_VIEW)
                }
                i % 3 == 0 -> {
                    listViewType2.add(MultiViewRecyclerAdapter.IMAGE_VIEW)
                }
                else -> {
                    listViewType2.add(MultiViewRecyclerAdapter.TEXT_WITH_IMAGE_VIEW)
                }
            }
        }
        // Adding delay of 2 seconds
        Handler().postDelayed(
            {
                if (::multiViewRecyclerAdapter.isInitialized) {
                    // Adapter is already initialized
                    // Just update the data
                    multiViewRecyclerAdapter.notifyDataSetChanged()
                } else {
                    // attach adapter to recycler view
                    multiViewRecyclerAdapter = MultiViewRecyclerAdapter(this, listViewType2)
                    recyclerView2.adapter = multiViewRecyclerAdapter
                }
                isLoading = false
                progressBar.visibility = View.GONE
            }, 2000
        )
    }
}