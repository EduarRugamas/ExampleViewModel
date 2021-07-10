package com.deveduar.exampleviewmodel.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ScoreViewModelFactory constructor(private val finalScore:Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) return ScoreViewModel(finalScore) as T

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}