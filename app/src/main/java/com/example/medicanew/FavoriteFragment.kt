package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicanew.adapter.DoctorAdapter
import com.example.medicanew.databinding.FragmentFavoriteBinding
import com.example.medicanew.model.Doctor


class FavoriteFragment : Fragment() {

    var doctors = mutableListOf<Doctor>()
    var favDoctors = mutableListOf<Doctor>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        doctors.add(Doctor(R.drawable.img, "Dr. Travis Westaby", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_1, "Dr. Nathaniel Valle", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_2, "Dr. Beckett Calger", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_3, "Dr. Joda Srnsky", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_4, "Dr. Bernard Bliss", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_5, "Dr. Randy Wigham", "Cardiologist"))
        doctors.add(Doctor(R.drawable.img_6, "Dr. Jenny Watson", "Immunologist"))
        doctors.add(Doctor(R.drawable.img_7, "Dr. Raul Zirkind", "Neurologist"))
        doctors.add(Doctor(R.drawable.img_8, "Dr. Elijah Baranick", "Allergist"))


        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        for (doctor in doctors) {
            if (doctor.status){
                favDoctors.add(Doctor(doctor.img,doctor.name, doctor.specialty, doctor.status))
            }
        }

        var adapter = DoctorAdapter(favDoctors, object : DoctorAdapter.DoctorInterface{
            override fun onClick(doctor: Doctor) {

            }
        })
        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.favDocRv.adapter = adapter
        binding.favDocRv.layoutManager = manager

        return binding.root
    }

}