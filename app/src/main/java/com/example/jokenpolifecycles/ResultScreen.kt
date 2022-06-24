package com.example.jokenpolifecycles

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.jokenpolifecycles.databinding.FragmentResultScreenBinding


class ResultScreen : Fragment() {
    lateinit var engine: JokenpoEngine
    lateinit var bind:FragmentResultScreenBinding
    lateinit var resultText: TextView
    lateinit var aiResult: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentResultScreenBinding.inflate(inflater, container, false)
        engine = JokenpoEngine(resources.getStringArray(R.array.spinner))
        aiResult = bind.textView4
        resultText = bind.textView5



        val currentPlay = arguments?.getString("currentPlay")

        currentPlay?.let {
            updateResultText(currentPlay)
        }


        setHasOptionsMenu(true)
        return bind.root
    }


    private fun updateResultText(currentPlay: String){
        val resultGame = engine.calculateResult(currentPlay)
        resultText.text = when(resultGame){
            Result.WIN -> "Voce ganhou"
            Result.LOSS -> "Voce perdeu"
            else -> "Empatou"
        }
        aiResult.text ="App selecionou ${engine.aiPlay}"
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.second_screen_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
    }

}