package com.example.jokenpolifecycles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jokenpolifecycles.databinding.FragmentInitialScreenBinding


class InitialScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentInitialScreenBinding.inflate(inflater, container, false)
        binding.startActivityButton.setOnClickListener {
            val action = InitialScreenDirections.actionInitialScreenToGameNav()
            findNavController().navigate(action)
        }
        return binding.root
    }


}