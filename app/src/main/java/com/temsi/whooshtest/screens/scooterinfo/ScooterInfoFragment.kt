package com.temsi.whooshtest.screens.scooterinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.temsi.whooshtest.R
import com.temsi.whooshtest.databinding.FragmentScooterInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ScooterInfoFragment : Fragment() {

    private val viewModel by viewModel<ScooterInfoViewModel>{ parametersOf(
        ScooterInfoFragmentArgs.fromBundle(requireArguments()).scooterName
    )}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentScooterInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_scooter_info, container, false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

}