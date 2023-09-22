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


    var favDoctors = mutableListOf<Doctor>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val myShared = mySharedPreferences.newInstance(requireContext())
        favDoctors = myShared.favoriteDoctors()


        binding.back.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, HomeFragment())
                .commit()
        }


        var adapter = DoctorAdapter(favDoctors, object : DoctorAdapter.DoctorInterface{
            override fun onClick(doctor: Doctor) {

            }
        }, requireContext())
        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.favDocRv.adapter = adapter
        binding.favDocRv.layoutManager = manager

        binding.tv.text = favDoctors.size.toString()

        return binding.root
    }

}