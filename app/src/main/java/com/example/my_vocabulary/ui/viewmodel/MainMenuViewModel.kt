package com.example.my_vocabulary.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.my_vocabulary.data.repo.MyVocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor(var repository: MyVocabularyRepository): ViewModel() {
}