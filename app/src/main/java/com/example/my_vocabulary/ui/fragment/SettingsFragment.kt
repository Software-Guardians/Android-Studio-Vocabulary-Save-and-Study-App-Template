package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.my_vocabulary.R
import com.example.my_vocabulary.databinding.FragmentSettingsBinding
import com.example.my_vocabulary.ui.adapter.SettingsAdapter
import com.example.my_vocabulary.ui.viewmodel.SettingsViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    private lateinit var adapter: SettingsAdapter
    private lateinit var viewModel: SettingsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSettingsBinding.inflate(inflater,container,false)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            findNavController().navigate(R.id.mainMenuFragment)
            val bottomNavigationView=requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavigationView.selectedItemId=R.id.mainMenuFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= SettingsAdapter(requireContext(),viewModel.settingsList,viewModel)
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager= StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.HORIZONTAL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SettingsViewModel by viewModels()
        viewModel=tempViewModel
    }
}