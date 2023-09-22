package com.example.medicanew

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.medicanew.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignInBinding.inflate(inflater, container, false)
        var myShared = mySharedPreferences.newInstance(requireContext())

        val savedEmail = myShared.getUserEmail()
        val savedPassword = myShared.getUserPassword()

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.signup.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.signin.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (email == savedEmail && password == savedPassword){
                findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
            }
            else{
                Toast.makeText(requireContext(),"Incorrect email or password", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}