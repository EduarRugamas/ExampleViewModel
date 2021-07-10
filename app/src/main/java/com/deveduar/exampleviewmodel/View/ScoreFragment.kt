package com.deveduar.exampleviewmodel.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.deveduar.exampleviewmodel.R
import com.deveduar.exampleviewmodel.ViewModel.ScoreViewModel
import com.deveduar.exampleviewmodel.ViewModel.ScoreViewModelFactory
import com.deveduar.exampleviewmodel.databinding.FragmentScoreBinding


class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFacotry: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)

        viewModelFacotry = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)

        viewModel = ViewModelProvider(this, viewModelFacotry).get(ScoreViewModel::class.java)


        binding.scoreText.text = viewModel.score.toString()

        return binding.root
    }


}