package com.example.layoutsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val myArrayList = ArrayList<Model>()
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))
        myArrayList.add(Model(R.drawable.food1, "Ice Cream Sundae", "145 Mall of India", "520 reviews", "01 Mar 2019 11:30 AM", "Rs. 80"))

        var adapter : MyCustomAdapter = MyCustomAdapter(myArrayList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}