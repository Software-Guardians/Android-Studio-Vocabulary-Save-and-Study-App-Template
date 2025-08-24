package com.example.my_vocabulary.ui.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.fragment.findNavController
import com.example.my_vocabulary.R
import com.example.my_vocabulary.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        sharedPreferences=requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        binding.buttonLogin.setOnClickListener {
            val Name=binding.editTextUsername.text.toString()
            val Password=binding.editTextPassword.text.toString()
            val userLocal=sharedPreferences.getString(Name,"")
            //Is not Empty
            if(!binding.editTextPassword.text.isNullOrBlank() && !binding.editTextUsername.text.isNullOrBlank()) {
                if(userLocal==Password){

                    findNavController().navigate(R.id.action_loginFragment_to_mainMenuFragment)
                }
                else{
                    Toast.makeText(requireContext(),"Login Failed.Username or password is incorrect" ,Toast.LENGTH_SHORT).show()
                }
            }
        }


        return binding.root
    }

}