package com.example.medicanew.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.medicanew.R
import com.example.medicanew.model.Carousel
import com.google.android.material.tabs.TabLayout

class CarouselAdapter(var list:MutableList<Carousel>, var context:Context) : PagerAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.carousel_custom, container, false)
        var item = list[position]
        var text:TextView = view.findViewById(R.id.textView)
        var img:ImageView = view.findViewById(R.id.imageView)
        text.text = item.str
        img.setImageResource(item.img)

        container.addView(view,position)
        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}