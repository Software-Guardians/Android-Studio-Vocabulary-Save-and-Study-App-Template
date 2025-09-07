package com.example.my_vocabulary.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel() {
    val refreshData= MutableLiveData<Boolean>()
    init {
        refreshData.value=false
    }
}