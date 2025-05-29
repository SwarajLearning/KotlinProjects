package com.example.sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var recyclerViewSports: RecyclerView
    private lateinit var sportsAdapter: SportsAdapter
    private lateinit var arrayListSports: ArrayList<Sports>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewSports = findViewById(R.id.rvSports)

        arrayListSports = arrayListOf(
            Sports(R.drawable.basketball, "Basketball"),
            Sports(R.drawable.football, "Football"),
            Sports(R.drawable.ping, "Ping"),
            Sports(R.drawable.tennis, "Tennis"),
        )

        sportsAdapter = SportsAdapter(this, arrayListSports, this)

        recyclerViewSports.layoutManager = LinearLayoutManager(this)
        recyclerViewSports.adapter = sportsAdapter


    }

    override fun onClickCustomListener(view: View?, position: Int) {
        Toast.makeText(this, arrayListSports[position].name, Toast.LENGTH_SHORT).show()
    }
}