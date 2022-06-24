package com.example.jokenpolifecycles

import kotlin.random.Random

enum class Result{
    WIN,
    DRAW,
    LOSS
}

class JokenpoEngine(val avalablePlays: Array<String>) {
lateinit var aiPlay:String

    fun calculateResult(playerPlay:String):Result{
        aiPlay = getAIPlay()
        return when{
            playerPlay == aiPlay -> Result.DRAW
            playerPlay == "Pedra" && aiPlay == "Tesoura" -> Result.WIN
            playerPlay == "Pedra" && aiPlay == "Papel" -> Result.LOSS
            playerPlay == "Papel" && aiPlay == "Tesoura"-> Result.LOSS
            playerPlay == "Papel" && aiPlay == "Pedra" -> Result.WIN
            playerPlay == "Tesoura" && aiPlay == "Papel" -> Result.WIN
            else -> Result.LOSS
        }

    }


   private fun getAIPlay():String{
        val index = Random.nextInt(0,2)
        return avalablePlays[index]
    }


}