package com.example.medicanew.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.medicanew.R
import com.example.medicanew.model.Doctor

class DoctorAdapter(var list: MutableList<Doctor>, var doctorInterface: DoctorInterface, var context: Context) : RecyclerView.Adapter<DoctorAdapter.DoctorHolder>(){

    class DoctorHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name:TextView = itemView.findViewById(R.id.name)
        var img:ImageView = itemView.findViewById(R.id.img)
        var status:ImageView = itemView.findViewById(R.id.status)
        var specialty:TextView = itemView.findViewById(R.id.specialty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorHolder {
        return DoctorHolder(LayoutInflater.from(parent.context).inflate(R.layout.doctor_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DoctorHolder, position: Int) {
        var item = list[position]
        holder.name.text = item.name
        holder.img.setImageResource(item.img)
        holder.specialty.text = item.specialty
        holder.status.setOnClickListener {
            if (!item.status){
                holder.status.setImageResource(R.drawable.baseline_favorite_blue_24)
                item.status = true
                Toast.makeText(context, item.status.toString(), Toast.LENGTH_SHORT).show()
            }else{
                holder.status.setImageResource(R.drawable.baseline_favorite_border_blue_24)
                item.status = false
                Toast.makeText(context, item.status.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        holder.itemView.setOnClickListener {
            doctorInterface.onClick(item)
        }
    }

    interface DoctorInterface{
        fun onClick(doctor: Doctor)
    }
}