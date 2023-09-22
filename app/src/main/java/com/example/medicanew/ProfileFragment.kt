package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.medicanew.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        val myShared = mySharedPreferences.newInstance(requireContext())

        binding.logout.setOnClickListener {
            val myDialogFragment = Dialog()
            val manager = parentFragmentManager
            myDialogFragment.show(manager, "myDialog")
            findNavController().navigate(R.id.action_mainFragment_to_welcomeFragment)

        }

        return binding.root
    }

}