package com.deveduar.exampleviewmodel.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    var word:String = ""
    var score:Int = 0

    private lateinit var  wordList: MutableList<String>

    private fun resetList(){
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        resetList()
        nextWord()
        Log.i(TAG, "GameViewModel Creado!!!")
    }

    private fun nextWord(){
        if(!wordList.isEmpty()){
            word = wordList.removeAt(0)
        }
    }

    fun onSkip(){
        score--
        nextWord()
    }
    fun onCorrect(){
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "GameViewModel Destruido")
    }



    companion object {
        const val TAG = "GameViewModel"
    }
}