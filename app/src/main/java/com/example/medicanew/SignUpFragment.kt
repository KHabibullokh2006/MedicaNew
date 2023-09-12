package com.example.medicanew

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.medicanew.databinding.FragmentSignUpBinding
import com.example.medicanew.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SignUpFragment : Fragment() {

    var userList = mutableListOf<User>()

    @SuppressLint("CommitPrefEdits")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignUpBinding.inflate(inflater, container, false)

        var myShared = mySharedPreferences(requireContext())

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.signin.setOnClickListener {

//            if (validate())

            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        return binding.root
    }

}