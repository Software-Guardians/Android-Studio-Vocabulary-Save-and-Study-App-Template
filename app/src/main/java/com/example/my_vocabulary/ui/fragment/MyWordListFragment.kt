package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.my_vocabulary.R
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.databinding.FragmentMyWordListBinding
import com.example.my_vocabulary.ui.adapter.MyWordListAdapter
import com.example.my_vocabulary.ui.viewmodel.MyWordListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyWordListFragment : Fragment() {
    private lateinit var binding: FragmentMyWordListBinding
    private lateinit var viewModel: MyWordListViewModel
    private lateinit var adapter: MyWordListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyWordListBinding.inflate(inflater,container,false)
        viewModel.getAllWord(applicationData.user_name_global)
        adapter= MyWordListAdapter(requireContext(),emptyList(),viewModel)
        viewModel.vocabularyList.observe(viewLifecycleOwner){list->
            adapter.setData(list)
        }
        binding.recyclerViewMyWorldList.adapter=adapter
        binding.recyclerViewMyWorldList.layoutManager= LinearLayoutManager(requireContext())
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){

        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MyWordListViewModel by viewModels()
        viewModel=tempViewModel
    }

}