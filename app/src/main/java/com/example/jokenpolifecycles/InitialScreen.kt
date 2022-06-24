package com.example.jokenpolifecycles

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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