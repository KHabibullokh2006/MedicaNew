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
        val myShared = mySharedPreferences.newInstance(requireContext())
        doctors = myShared.addDoctors()


        var adapter = DoctorAdapter(doctors, object : DoctorAdapter.DoctorInterface{
            override fun onClick(doctor: Doctor) {
                var bundle = Bundle()
                bundle.putSerializable("doc",doctor)

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
            findNavController().navigate(R.id.action_mainFragment_to_searchFragment)
        }



        return binding.root
    }

}