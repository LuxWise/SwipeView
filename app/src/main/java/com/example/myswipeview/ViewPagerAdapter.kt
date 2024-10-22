package com.example.myswipeview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(
    private var title: List<String>,
    private var details: List<String>,
    private var image: List<Int>
) : RecyclerView.Adapter<ViewPageAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val itemDetails: TextView = itemView.findViewById(R.id.tvAbout)
        val itemImage: ImageView = itemView.findViewById(R.id.ivImage)

        init {
            itemImage.setOnClickListener{ v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item # ${position + 1}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_page,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = details[position]
        holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }
}
