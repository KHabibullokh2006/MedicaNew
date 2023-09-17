package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medicanew.databinding.FragmentHistoryBinding
import com.google.android.material.tabs.TabLayout


class HistoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)

        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Message"))
        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Voice Call"))
        binding.tabLayout2.addTab(binding.tabLayout2.newTab().setText("Video Call"))
        binding.tabLayout2.tabGravity = TabLayout.GRAVITY_FILL

        return binding.root
    }


}