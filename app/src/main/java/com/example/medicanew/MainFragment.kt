package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.medicanew.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction().replace(R.id.mainFragment, HomeFragment()).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, HomeFragment())
                        .commit()
                }

                R.id.appointment -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, AppointmentFragment())
                        .commit()
                }

                R.id.history -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, HistoryFragment())
                        .commit()
                }

                R.id.articles -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, ArticlesFragment())
                        .commit()
                }

                R.id.profile -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.mainFragment, ProfileFragment())
                        .commit()
                }
            }
            true
        }


        return binding.root
    }


}