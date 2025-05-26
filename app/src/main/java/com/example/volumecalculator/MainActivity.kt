package com.example.volumecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var shapeArrayList: ArrayList<Shape>
    private lateinit var myCustomAdapter: MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)

        shapeArrayList = arrayListOf(
            Shape(R.drawable.sphere, "Sphere"),
            Shape(R.drawable.cylinder, "Cylinder"),
            Shape(R.drawable.cube, "Cube"),
            Shape(R.drawable.prism, "Prism"),
        )

        myCustomAdapter = MyCustomAdapter(applicationContext, shapeArrayList)

        gridView.adapter = myCustomAdapter
        gridView.numColumns = 2

        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext,
                shapeArrayList[position].shapeName,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}