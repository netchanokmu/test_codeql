package com.example.lab4.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R

class MyAdapter (val items: Array<String>, val imageId: Array<Int>):
    RecyclerView.Adapter<ModalViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModalViewHolder {
        return ModalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.model, parent,
            false))
    }

    override fun onBindViewHolder(holder: ModalViewHolder, position: Int) {
        holder.nameTextView.text = items.get(position)
        holder.imageIdView.setImageResource(imageId.get(position))
    }

    override fun getItemCount(): Int = items.size
}
class ModalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal var nameTextView : TextView = itemView.findViewById(R.id.nameTxt)
    internal var imageIdView : ImageView = itemView.findViewById(R.id.thumbnail)
}