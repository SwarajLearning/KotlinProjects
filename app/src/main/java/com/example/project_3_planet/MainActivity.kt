package com.example.project_3_planet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var planetArrayList: ArrayList<Planet>
    private lateinit var myCustomAdapter: MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        planetArrayList = ArrayList()

        planetArrayList.add(Planet("Earth", "1", R.drawable.earth))
        planetArrayList.add(Planet("Mercury", "2", R.drawable.mercury))
        planetArrayList.add(Planet("Venus", "3", R.drawable.venus))
        planetArrayList.add(Planet("Jupiter", "4", R.drawable.jupiter))
        planetArrayList.add(Planet("Saturn", "5", R.drawable.saturn))
        planetArrayList.add(Planet("Uranus", "6", R.drawable.uranus))
        planetArrayList.add(Planet("Neptune", "7", R.drawable.neptune))
        planetArrayList.add(Planet("Pluto", "8", R.drawable.pluto))

        myCustomAdapter = MyCustomAdapter(applicationContext, planetArrayList)
        listView.adapter = myCustomAdapter

        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                applicationContext,
                "Planet Name: ${myCustomAdapter.getItem(position)?.planetName}",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

}