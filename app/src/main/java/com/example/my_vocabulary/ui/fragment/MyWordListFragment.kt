package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.my_vocabulary.R
import com.example.my_vocabulary.databinding.FragmentMyWordListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyWordListFragment : Fragment() {
    private lateinit var binding: FragmentMyWordListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyWordListBinding.inflate(inflater,container,false)
        return binding.root
    }


}