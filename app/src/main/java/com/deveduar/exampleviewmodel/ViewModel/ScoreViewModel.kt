package com.deveduar.exampleviewmodel.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel constructor( finalScore: Int ): ViewModel() {

    val score = finalScore

    init {
        Log.i(TAG, "final Score is $finalScore")
    }


    companion object{
        const val TAG = "ScoreViewModel"
    }

}