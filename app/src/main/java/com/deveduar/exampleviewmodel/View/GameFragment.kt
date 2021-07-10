package com.deveduar.exampleviewmodel.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.deveduar.exampleviewmodel.R
import com.deveduar.exampleviewmodel.ViewModel.GameViewModel
import com.deveduar.exampleviewmodel.databinding.FragmentGameBinding
import kotlinx.coroutines.channels.consumesAll


class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container,false)

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            updateScoreText()
            updateWordText()
        }

        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
            updateScoreText()
            updateWordText()
        }

        binding.endGameButton.setOnClickListener {
            onEndGame()
        }

        updateWordText()
        updateScoreText()

        return binding.root
    }


    private fun updateWordText(){
        binding.wordText.text = viewModel.word
    }
    private fun updateScoreText(){
        binding.scoreText.text = viewModel.score.toString()
    }

    private fun onEndGame(){
        gamefinish()
    }

    private fun gamefinish(){
        Toast.makeText(requireContext(), "El juego ha finalizado", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment(viewModel.score)
        NavHostFragment.findNavController(this).navigate(action)

    }


}