package com.example.jokenpolifecycles

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpolifecycles.databinding.FragmentPlayerScreenBinding


class PlayerScreen : Fragment() {
lateinit var root: View
lateinit var destu: Menu

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val binding = FragmentPlayerScreenBinding.inflate(inflater, container, false)
        root = binding.root
        setHasOptionsMenu(true)

        return root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(findNavController())
    }

}


