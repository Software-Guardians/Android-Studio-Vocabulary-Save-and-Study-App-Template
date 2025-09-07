package com.example.my_vocabulary.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my_vocabulary.data.entity.Languages
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyWordListViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
    var vocabularyList= MutableLiveData<List<Vocabulary>>()

    fun getAllWord(user_name: String){
        CoroutineScope(Dispatchers.Main).launch {
            vocabularyList.value=repository.getAllVocabulary(user_name)
        }
    }
    fun insertVocabulary(defaultLanguage: Languages,translateLanguage: Languages,
                         text: String,translatedText: String,examples: String=""){
        CoroutineScope(Dispatchers.Main).launch {
            repository.insertVocabulary(defaultLanguage.displayName, translateLanguage.displayName,text, translatedText, examples, applicationData.user_name_global)
        }
    }
}