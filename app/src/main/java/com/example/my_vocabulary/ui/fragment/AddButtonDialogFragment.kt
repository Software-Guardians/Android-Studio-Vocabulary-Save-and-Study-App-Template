package com.example.my_vocabulary.ui.fragment

import android.os.Bundle
import android.text.InputFilter
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.my_vocabulary.R
import com.example.my_vocabulary.data.entity.Languages
import com.example.my_vocabulary.databinding.FragmentAddButtonDialogBinding
import com.example.my_vocabulary.ui.viewmodel.AddButtonDialogViewModel
import com.example.my_vocabulary.ui.viewmodel.SharedViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import org.intellij.lang.annotations.Language

@AndroidEntryPoint
class AddButtonDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddButtonDialogBinding
    private lateinit var viewModel: AddButtonDialogViewModel
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddButtonDialogViewModel by viewModels()
        viewModel=tempViewModel
        val tempSharedViewModel: SharedViewModel by viewModels()
        sharedViewModel=tempSharedViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddButtonDialogBinding.inflate(inflater,container,false)
        val maxLines = 1
        val maxCharsPerLine = 100

        binding.editTextExample.filters = arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            val newText = dest.replaceRange(dstart, dend, source.subSequence(start, end))
            val lines = newText.split("\n")
            if (lines.size > maxLines) return@InputFilter ""
            for (line in lines) {
                if (line.length > maxCharsPerLine) return@InputFilter ""
            }

            null
        })
        val languageList=mutableListOf("Please choose a language for your word")
        languageList.addAll(Languages.values().map { it.displayName })
        val adapter= ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            languageList
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDefaultLanguage.adapter=adapter
        binding.spinnerDefaultLanguage.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                if(p2==0){
                    return
                }
                val selectedLanguage= Languages.values()[p2 - 1]
                Toast.makeText(requireContext(),"${selectedLanguage.displayName} is choosen.",
                    Toast.LENGTH_SHORT ).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        val languageTranslateList=mutableListOf("Please choose a translate language for your word")
        languageTranslateList.addAll(Languages.values().map { it.displayName })
        val adapterTranslate= ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            languageTranslateList
        )
        adapterTranslate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTranslateLanguage.adapter=adapterTranslate
        binding.spinnerTranslateLanguage.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                p0: AdapterView<*>?,
                p1: View?,
                p2: Int,
                p3: Long
            ) {
                if(p2== 0)return
                val selectedLanguage= Languages.values()[p2-1]
                Toast.makeText(requireContext(),"${selectedLanguage.displayName} is choosen as translate language.",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        binding.buttonADD.setOnClickListener {
            if(binding.spinnerDefaultLanguage.selectedItemPosition==0){
                Toast.makeText(requireContext(),"Please choose a language.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.spinnerTranslateLanguage.selectedItemPosition==0) {
                Toast.makeText(requireContext(),"Please choose a translate language.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.editTextText.text.toString().isNullOrBlank()){
                Toast.makeText(requireContext(),"Please type a word.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.editTextTranslatedText.text.toString().isNullOrBlank()){
                Toast.makeText(requireContext(),"Please type the translation of the word.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val defaultLanguage= Languages.values().find { it.displayName==binding.spinnerDefaultLanguage.selectedItem.toString()}!!
            val translateLanguage= Languages.values().find { it.displayName==binding.spinnerTranslateLanguage.selectedItem.toString()}!!
            val word=binding.editTextText.text.toString()
            val translate=binding.editTextTranslatedText.text.toString()
            val example=binding.editTextExample.text.toString()
            viewModel.insertVocabulary(defaultLanguage,translateLanguage,word,translate,example)
            Toast.makeText(requireContext(),"Word saved with succesfully.", Toast.LENGTH_SHORT).show()
            setFragmentResult("wordSaved", bundleOf("success" to true))
            dismiss()
        }
        return binding.root
    }


}