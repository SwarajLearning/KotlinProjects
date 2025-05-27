package com.example.volumecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var arrayListItem: ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvGrocery)

        arrayListItem = arrayListOf(
            Item(R.drawable.milk, "Milk", "Milk is a good product"),
            Item(R.drawable.beverage, "Beverage", "Beverage is a good product"),
            Item(R.drawable.bread, "Bread", "Bread is a good product"),
            Item(R.drawable.fruit, "Fruit", "Fruit is a good product"),
            Item(R.drawable.popcorn, "Popcorn", "Popcorn is a good product"),
            Item(R.drawable.vegetables, "Vegetables", "Vegetables is a good product")
        )


        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(this, arrayListItem, this)

    }

    override fun onClick(view: View, position: Int) {
        Toast.makeText(
            this,
            "${arrayListItem[position].itemName} : ${arrayListItem[position].itemDesc}",
            Toast.LENGTH_SHORT
        ).show()
    }
}