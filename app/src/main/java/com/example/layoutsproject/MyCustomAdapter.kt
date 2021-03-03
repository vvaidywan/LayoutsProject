package com.example.layoutsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCustomAdapter(val myArrayList: ArrayList<Model>) : RecyclerView.Adapter<MyCustomAdapter.MyCustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
        )
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        holder.img.setImageResource(myArrayList[position].img)
        holder.tvname.text = myArrayList[position].name
        holder.tvaddress.text = myArrayList[position].address
        holder.tvreviews.text = myArrayList[position].reviews
        holder.tvtime.text = myArrayList[position].time
        holder.tvprice.text = myArrayList[position].price
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    class MyCustomViewHolder(item_view : View) : RecyclerView.ViewHolder(item_view) {
        val img = item_view.findViewById<ImageView>(R.id.img)
        val tvname = item_view.findViewById<TextView>(R.id.tvname)
        val tvaddress = item_view.findViewById<TextView>(R.id.tvaddress)
        val tvreviews = item_view.findViewById<TextView>(R.id.tvreviews)
        val tvtime = item_view.findViewById<TextView>(R.id.tvtime)
        val tvprice = item_view.findViewById<TextView>(R.id.tvprice)

    }
}