package com.example.android.guessinggame.viewmodel

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val word = listOf("Android", "Activity", "Fragment","Layout","C0omponents")
    private val secretWord = word.random().uppercase()
    var secretWordDisplay = ""
    private var correctGuess = ""
    var wrongGuess = ""
    var livesLeft = 8

    init {
        secretWordDisplay = derivedSecretWordDisplay()
    }

    private fun derivedSecretWordDisplay(): String {
        var display = ""
        secretWord.forEach {
            display += checkLetter(it.toString())
        }
        return display
    }

    private fun checkLetter(toString: String) = when (correctGuess.contains(toString)) {
        true -> toString
        false -> "_"
    }

    fun makeGuess(guess: String) {
        if (guess.length == 1) {
            if (secretWord.contains(guess)) {
                correctGuess += guess
                secretWordDisplay = derivedSecretWordDisplay()
            } else {
                wrongGuess += guess
                livesLeft--
            }
        }
    }

    fun wonLossMessage(): String {
        var message = ""
        if (isWon()) message = "You win!"
        else if (isLoss()) message = "You lost!"
        message += "The word was $secretWord"
        return message
    }

    fun isLoss(): Boolean = livesLeft <= 0

    fun isWon(): Boolean = secretWord.equals(secretWordDisplay, true)
}