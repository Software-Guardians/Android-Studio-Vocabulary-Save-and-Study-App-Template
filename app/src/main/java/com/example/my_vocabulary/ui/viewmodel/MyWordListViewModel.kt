package com.example.my_vocabulary.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyWordListViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
    var vocabularyList= MutableLiveData<List<Vocabulary>>()

    fun getAllWord(){
        CoroutineScope(Dispatchers.Main).launch {
            vocabularyList.value=repository.getAllVocabulary()
        }
    }

}