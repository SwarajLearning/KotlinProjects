package com.example.volumecalculator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class MyCustomAdapter(private val context: Context, private val shapeArrayList: ArrayList<Shape>) :
    ArrayAdapter<Shape>(context, 0, shapeArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val shapeList = shapeArrayList[position]

        holder.textView.text = shapeList.shapeName
        holder.imageView.setImageResource(shapeList.shapeImage)

        return view
    }

    class ViewHolder(view: View) {
        var imageView: AppCompatImageView = view.findViewById(R.id.imageView)
        var textView: AppCompatTextView = view.findViewById(R.id.textView)
    }
}
