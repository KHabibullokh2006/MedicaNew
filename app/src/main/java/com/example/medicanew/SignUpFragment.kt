package com.example.medicanew

import android.annotation.SuppressLint
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.medicanew.databinding.FragmentSignUpBinding
import com.example.medicanew.model.User
import com.google.android.material.textfield.TextInputEditText
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

        val myShared = mySharedPreferences.newInstance(requireContext())



        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.signup.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val username = binding.username.text.toString()

            myShared.saveUser(username, email, password)

            if (email != "" && password != ""){
                findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
            }
            else{
                Toast.makeText(requireContext(),"Fill the form fully", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        return binding.root
    }

}