package com.example.medicanew

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class CarouselAdapter(var list:MutableList<Carousel>, var context:Context) : RecyclerView.Adapter<CarouselAdapter.CarouselHolder>() {

    class CarouselHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tablayout = itemView.findViewById<TabLayout>(R.id.tabLayout)
        var viewpager = itemView.findViewById<ViewPager2>(R.id.viewPager2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_carousel, parent, false)
        return CarouselHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CarouselHolder, position: Int) {
        var item = list[position]

    }

}