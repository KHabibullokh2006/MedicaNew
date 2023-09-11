package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.medicanew.databinding.FragmentCarouselBinding


class CarouselFragment : Fragment() {

    val list = mutableListOf<Carousel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCarouselBinding.inflate(inflater, container, false)


        list.add(Carousel(R.drawable.img2,"Thousand of \n doctors and experts to \n help your health!"))
        list.add(Carousel(R.drawable.img3,"Health checks and \n consultation easily \n anywhere anytime"))
        list.add(Carousel(R.drawable.img4,"Let's start living \n healthy and well \n with us right now!"))

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_carouselFragment_to_welcomeFragment)
        }



        return binding.root
    }


}