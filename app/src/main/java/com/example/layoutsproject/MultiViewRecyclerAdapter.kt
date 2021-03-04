package com.example.layoutsproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiViewRecyclerAdapter(private val context: Context, private val listViewType: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TEXT_VIEW = 1
        const val IMAGE_VIEW = 2
        const val TEXT_WITH_IMAGE_VIEW = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_VIEW -> ViewHolderText(inflater.inflate(R.layout.type_text, parent, false))
            IMAGE_VIEW -> ViewHolderImage(inflater.inflate(R.layout.type_image, parent, false))
            TEXT_WITH_IMAGE_VIEW -> ViewHolderImageText(inflater.inflate(R.layout.type_text_with_image, parent, false))
            else -> throw IllegalArgumentException("No Holder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (listViewType[position]) {
            TEXT_VIEW -> {
                val viewHolderText = holder as ViewHolderText
                viewHolderText.textView.text = context.getString(R.string.new_offers_amp_discount)
            }
            IMAGE_VIEW -> {
                val viewHolderImage = holder as ViewHolderImage
                viewHolderImage.offerImage.setBackgroundResource(if (position == 1) R.drawable.holiday1 else R.drawable.holiday2)
            }
            TEXT_WITH_IMAGE_VIEW -> {
                val restaurantViewHolder = holder as ViewHolderImageText
                restaurantViewHolder.restaurantText.text = context.getString(R.string.hotel_offer_desc)
                restaurantViewHolder.restaurantImage.setBackgroundResource(if (position == 2) R.drawable.holiday3 else R.drawable.holiday4)
            }
            else -> {
                throw IllegalArgumentException("No Bind Holder")
            }
        }
    }

    override fun getItemCount(): Int {
        return listViewType.size
    }

    override fun getItemViewType(position: Int): Int = listViewType[position]

    //View holders for each unique view type
    inner class ViewHolderText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.typeText)
    }

    inner class ViewHolderImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage: ImageView = itemView.findViewById(R.id.typeImg)
    }

    inner class ViewHolderImageText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantText: TextView = itemView.findViewById(R.id.TIText)
        val restaurantImage: ImageView = itemView.findViewById(R.id.TIImage)
    }

}