package com.example.my_vocabulary.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_vocabulary.data.entity.Languages
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class AddButtonDialogViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
    var vocabularyList= MutableLiveData<List<Vocabulary>>()
    fun insertVocabulary(defaultLanguage: Languages,translateLanguage: Languages,
                         text: String,translatedText: String,examples: String=""){
        CoroutineScope(Dispatchers.Main).launch {
            repository.insertVocabulary(defaultLanguage.displayName, translateLanguage.displayName,text, translatedText, examples, applicationData.user_name_global)
        }
    }
}