package com.example.expandanimation

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.navigation.Navigation
import com.example.expandanimation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            expandAnimation()
        }

        binding.button2.setOnClickListener {
            shrinkAnimation()
        }

    }

    private fun expandAnimation() {

        binding.lottieAnimationView.animate().apply {
            scaleX(13.5f)
            scaleY(13.5f)
            duration = 2500
            interpolator = AccelerateDecelerateInterpolator()
            start()

        }

        val animationDuration = 2200L
        Handler().postDelayed({
            val action = FirstFragmentDirections.actionFirstFragmentToFragmentSecond()
            Navigation.findNavController(binding.root).navigate(action)
        }, animationDuration)
    }

    private fun shrinkAnimation() {

        binding.lottieAnimationView.animate().apply {
            scaleX(0.001f)
            scaleY(0.001f)
            duration = 2000
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
    }
}