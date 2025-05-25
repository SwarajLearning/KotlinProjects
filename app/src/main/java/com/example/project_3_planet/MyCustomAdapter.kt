package com.example.project_3_planet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class MyCustomAdapter(
    private val context: Context,
    private val planetArrayList: ArrayList<Planet>
) :
    ArrayAdapter<Planet>(context, 0, planetArrayList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_layout, parent, false);
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val planetList = planetArrayList[position]
        holder.tvPlanetName.text = planetList.planetName
        holder.tvPlanetNumber.text = planetList.planetNumber
        holder.tvPlanetName.text = planetList.planetName
        holder.tvPlanetImage.setImageResource(planetList.planetImage)

        return view
    }

    class ViewHolder(view: View) {
        var tvPlanetName: AppCompatTextView = view.findViewById(R.id.tvPlanetName)
        var tvPlanetNumber: AppCompatTextView = view.findViewById(R.id.tvPlanetNumber)
        var tvPlanetImage: AppCompatImageView = view.findViewById(R.id.ivPlanetImage)
    }

}