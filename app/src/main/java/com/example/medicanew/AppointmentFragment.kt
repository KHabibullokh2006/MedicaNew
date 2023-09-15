package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medicanew.databinding.FragmentAppointmentBinding
import com.google.android.material.tabs.TabLayout


class AppointmentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAppointmentBinding.inflate(inflater, container, false)

        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Upcoming"))
        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Completed"))
        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Cancelled"))
        binding.tabLayout2.tabGravity = TabLayout.GRAVITY_FILL

        return binding.root
    }

}