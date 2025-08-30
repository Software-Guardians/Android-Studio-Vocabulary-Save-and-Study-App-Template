package com.example.my_vocabulary.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class AddButtonDialogViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
    var vocabularyList= MutableLiveData<List<Vocabulary>>()
    fun insertVocabulary(defaultLanguage: String,translateLanguage: String,
                         text: String,translatedText: String,examples: String,user_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            repository.insertVocabulary(defaultLanguage, translateLanguage,text, translatedText, examples, user_name)
        }
    }
}