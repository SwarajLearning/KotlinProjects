package com.example.sports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SportsAdapter(private val context: Context, private val arrayListSports: ArrayList<Sports>, private val clickListener: ClickListener): RecyclerView.Adapter<SportsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayListSports.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvSports.text = arrayListSports[position].name

        Glide.with(context)
            .load(arrayListSports[position].image)
            .into(holder.ivSports)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), OnClickListener {
        val tvSports: AppCompatTextView = itemView.findViewById(R.id.tvSports)
        val ivSports: AppCompatImageView = itemView.findViewById(R.id.ivSports)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            clickListener.onClickCustomListener(v, adapterPosition)
        }
    }
}