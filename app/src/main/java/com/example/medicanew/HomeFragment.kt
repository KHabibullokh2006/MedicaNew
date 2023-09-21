package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicanew.adapter.DoctorAdapter
import com.example.medicanew.databinding.FragmentHomeBinding
import com.example.medicanew.model.Doctor


class HomeFragment : Fragment() {

    var doctors = mutableListOf<Doctor>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val myShared = mySharedPreferences(requireContext())

        doctors.add(Doctor(R.drawable.img, "Dr. Travis Westaby", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_1, "Dr. Nathaniel Valle", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_2, "Dr. Beckett Calger", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_3, "Dr. Joda Srnsky", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_4, "Dr. Bernard Bliss", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_5, "Dr. Randy Wigham", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_6, "Dr. Jenny Watson", "Immunologist"))
        doctors.add(Doctor(R.drawable.img_7, "Dr. Raul Zirkind", "Neurologist"))
        doctors.add(Doctor(R.drawable.img_8, "Dr. Elijah Baranick", "Allergist"))

        var adapter = DoctorAdapter(doctors,  object : DoctorAdapter.DoctorInterface{
            override fun onClick(doctor: Doctor) {

            }
        }, requireContext())
        var manager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.doctorsRv.adapter = adapter
        binding.doctorsRv.layoutManager = manager

        binding.username.text= myShared.getUserUsername()

        binding.notification.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, NotificationFragment())
                .commit()
        }

        binding.favorite.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, FavoriteFragment())
                .commit()
        }

        binding.editText.addTextChangedListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, SearchFragment())
                .commit()
        }



        return binding.root
    }

}