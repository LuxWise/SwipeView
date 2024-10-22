package com.example.myswipeview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var detailsList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        postToList()

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        viewPager2.adapter = ViewPageAdapter(titlesList, detailsList, imagesList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager2)

    }

    private fun addToList(title:  String, details: String, image: Int) {
        titlesList.add(title)
        detailsList.add(details)
        imagesList.add(image)
    }

    private fun postToList() {
        for(i in 1..10) {
            addToList("Title $i", "Details $i", R.drawable.ic_launcher_foreground)
        }
    }
}