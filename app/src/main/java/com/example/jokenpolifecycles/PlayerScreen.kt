package com.example.jokenpolifecycles

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpolifecycles.databinding.FragmentPlayerScreenBinding


class PlayerScreen : Fragment() {
private lateinit var root: View
private lateinit var selectPlay: Spinner
private lateinit var onItemSelectedListener: AdapterView.OnItemSelectedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onItemSelectedListener = context as AdapterView.OnItemSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = FragmentPlayerScreenBinding.inflate(inflater, container, false)
        root = binding.root

        selectPlay = binding.spinner
        setHasOptionsMenu(true)
        setupSelectPlaySpinner()

        return root
    }

    private fun setupSelectPlaySpinner(){
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.spinner,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        selectPlay.adapter = adapter
        selectPlay.onItemSelectedListener = onItemSelectedListener
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(findNavController())
    }


}


