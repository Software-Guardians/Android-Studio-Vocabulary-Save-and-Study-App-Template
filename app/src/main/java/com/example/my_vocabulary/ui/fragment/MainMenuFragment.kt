package com.example.my_vocabulary.ui.fragment

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import com.example.my_vocabulary.MainActivity
import com.example.my_vocabulary.R
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.databinding.FragmentMainMenuBinding
import com.example.my_vocabulary.ui.viewmodel.MainMenuViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainMenuFragment : Fragment() {
    private lateinit var binding: FragmentMainMenuBinding
    private lateinit var viewModel: MainMenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainMenuBinding.inflate(inflater,container,false)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            Snackbar.make(requireView(),"Are you sure exit the application?", Snackbar.LENGTH_SHORT).setAction("Exit"){
                requireActivity().finish()
            }.show()
        }
        (requireActivity() as MainActivity).isLogin()
        binding.tvUserName.text= applicationData.user_name_global
        binding.floatingActionButtonAddWordMainMenu.setOnClickListener {

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainMenuViewModel by viewModels()
        viewModel=tempViewModel
    }
}