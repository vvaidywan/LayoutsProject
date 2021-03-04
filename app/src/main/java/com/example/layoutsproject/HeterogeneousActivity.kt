package com.example.layoutsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HeterogeneousActivity : AppCompatActivity() {

    private lateinit var heteroRV : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heterogeneous)

        heteroRV = findViewById(R.id.heteroRv)
        heteroRV.layoutManager = LinearLayoutManager(this)
        val listViewType = mutableListOf(
            MultiViewRecyclerAdapter.TEXT_VIEW,
            MultiViewRecyclerAdapter.IMAGE_VIEW,
            MultiViewRecyclerAdapter.TEXT_WITH_IMAGE_VIEW,
            MultiViewRecyclerAdapter.TEXT_VIEW,
            MultiViewRecyclerAdapter.TEXT_WITH_IMAGE_VIEW,
            MultiViewRecyclerAdapter.IMAGE_VIEW
        )
        val adapterRecyclerView = MultiViewRecyclerAdapter(this, listViewType = listViewType)
        heteroRV.adapter = adapterRecyclerView
    }
}