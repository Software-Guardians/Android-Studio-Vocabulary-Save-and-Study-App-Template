package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.my_vocabulary.R
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.databinding.FragmentMyWordListBinding
import com.example.my_vocabulary.ui.adapter.MyWordListAdapter
import com.example.my_vocabulary.ui.viewmodel.MyWordListViewModel
import com.example.my_vocabulary.ui.viewmodel.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyWordListFragment : Fragment() {
    private lateinit var binding: FragmentMyWordListBinding
    private lateinit var viewModel: MyWordListViewModel
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var adapter: MyWordListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMyWordListBinding.inflate(inflater,container,false)
        viewModel.getAllWord(applicationData.user_name_global)
        adapter= MyWordListAdapter(requireContext(),emptyList(),viewModel)

        binding.recyclerViewMyWorldList.adapter=adapter
        binding.recyclerViewMyWorldList.layoutManager= LinearLayoutManager(requireContext())

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            findNavController().navigate(R.id.mainMenuFragment)
            val bottomNavigationView=requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
            bottomNavigationView.selectedItemId=R.id.mainMenuFragment
        }
        binding.floatingActionButtonAddWord.setOnClickListener {
            findNavController().navigate(R.id.action_myWordListFragment_to_addButtonDialogFragment)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MyWordListViewModel by viewModels()
        viewModel=tempViewModel
        val tempSharedViewModel: SharedViewModel by viewModels()
        sharedViewModel=tempSharedViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.vocabularyList.observe(viewLifecycleOwner){vocabularyList->
            adapter.setData(vocabularyList.reversed())
        }
        setFragmentResultListener("wordSaved"){_,bundle ->
            if (bundle.getBoolean("success")){
                adapter.notifyDataSetChanged()

            }

        }
    }

}