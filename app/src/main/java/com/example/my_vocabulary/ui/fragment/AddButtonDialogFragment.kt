package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.my_vocabulary.R
import com.example.my_vocabulary.databinding.FragmentAddButtonDialogBinding
import com.example.my_vocabulary.ui.viewmodel.AddButtonDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddButtonDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddButtonDialogBinding
    private lateinit var viewModel: AddButtonDialogViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddButtonDialogViewModel by viewModels()
        viewModel=tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddButtonDialogBinding.inflate(inflater,container,false)
        return binding.root
    }


}