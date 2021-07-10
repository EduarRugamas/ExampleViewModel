package com.deveduar.exampleviewmodel.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.deveduar.exampleviewmodel.R
import com.deveduar.exampleviewmodel.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)

        binding.playGameButton.setOnClickListener {

            findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        return binding.root
    }


}