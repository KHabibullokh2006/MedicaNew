package com.example.medicanew

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicanew.adapter.DoctorAdapter
import com.example.medicanew.databinding.FragmentSearchBinding
import com.example.medicanew.model.Doctor

class SearchFragment : Fragment() {

    var doctors = mutableListOf<Doctor>()
    var searchDoc = mutableListOf<Doctor>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false)
        val myShared = mySharedPreferences.newInstance(requireContext())
        doctors = myShared.addDoctors()

        var adapter = DoctorAdapter(doctors, object : DoctorAdapter.DoctorInterface{
            override fun onClick(doctor: Doctor) {
                var bundle = Bundle()
                bundle.putSerializable("doc",doctor)

            }
        }, requireContext())
        var manager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.searchRv.adapter = adapter
        binding.searchRv.layoutManager = manager

        binding.search.addTextChangedListener {
            for (doctor in doctors) {
                if (doctor.name.toLowerCase().contains(binding.search.text.toString().toLowerCase())){
                    searchDoc.add(doctor)
                }
            }
            adapter.list = searchDoc
            adapter.notifyDataSetChanged()
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}