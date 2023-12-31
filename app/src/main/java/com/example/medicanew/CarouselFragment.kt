package com.example.medicanew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.medicanew.adapter.CarouselAdapter
import com.example.medicanew.databinding.FragmentCarouselBinding
import com.example.medicanew.model.Carousel


class CarouselFragment : Fragment() {

    private val list = mutableListOf<Carousel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCarouselBinding.inflate(inflater, container, false)

        val adapter = CarouselAdapter(list, requireContext())


        list.add(Carousel(R.drawable.img2,"Thousand of \n doctors and experts to \n help your health!"))
        list.add(Carousel(R.drawable.img3,"Health checks and \n consultation easily \n anywhere anytime"))
        list.add(Carousel(R.drawable.img4,"Let's start living \n healthy and well \n with us right now!"))

        binding.viewPager.adapter = adapter
        binding.viewPager.pageMargin = 15
        binding.viewPager.setPadding(50, 0, 50, 0);
        binding.viewPager.clipToPadding = false
        binding.viewPager.pageMargin = 25

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_carouselFragment_to_welcomeFragment)
        }

        return binding.root
    }

}