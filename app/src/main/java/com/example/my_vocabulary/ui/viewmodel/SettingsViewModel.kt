package com.example.my_vocabulary.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_vocabulary.data.entity.Settings
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.data.entity.applicationData
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
    var vocabularyList: LiveData<List<Vocabulary>> = repository.getAllVocabulary(applicationData.user_name_global)
    var settingsList= ArrayList<Settings>()
    init {
        var settings= Settings("Remove All Words","It deletes all words for the active user. Statistics are affected accordingly.","Are you sure want to remove all word datas?")

        settingsList.add(settings)
    }
    fun removeAllDatas(){
        CoroutineScope(Dispatchers.Main).launch {
            repository.deleteAllVocabulary(applicationData.user_name_global)
        }

    }

}