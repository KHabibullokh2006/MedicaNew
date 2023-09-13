package com.example.medicanew

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.medicanew.model.Carousel
import com.google.android.material.tabs.TabLayout

class CarouselAdapter(var list:MutableList<Carousel>, var context:Context) : PagerAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }


}