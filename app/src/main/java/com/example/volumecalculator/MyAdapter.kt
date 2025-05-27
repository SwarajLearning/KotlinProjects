package com.example.volumecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val context: Context,
    private val itemList: List<Item>,
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = itemList[position]

        holder.textViewTitle.text = items.itemName
        holder.textViewSubtitle.text = items.itemDesc
        holder.imageView.setImageResource(items.itemImage)
    }

    inner class ViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {
        var imageView: AppCompatImageView = itemView.findViewById(R.id.imageView)
        var textViewTitle: AppCompatTextView = itemView.findViewById(R.id.tvTitle)
        var textViewSubtitle: AppCompatTextView = itemView.findViewById(R.id.tvSubtitle)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener.onClick(itemView, adapterPosition)
        }
    }
}