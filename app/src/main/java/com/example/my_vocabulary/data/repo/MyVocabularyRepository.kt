package com.example.my_vocabulary.data.repo

import com.example.my_vocabulary.data.datasource.MyVocabularyDataSource
import com.example.my_vocabulary.data.entity.Vocabulary
import javax.inject.Inject

class MyVocabularyRepository @Inject constructor(var myVocabularyDataSource: MyVocabularyDataSource) {
    suspend fun getVocabulary(id: Int) = myVocabularyDataSource.getByID(id)
    suspend fun getAllVocabulary() = myVocabularyDataSource.getAllVocabulary()
    suspend fun insertVocabulary(defaultLanguage: String, translateLanguage: String, text: String, translatedText: String,examples: String) = myVocabularyDataSource.insertVocabulary(defaultLanguage,translateLanguage,text,translatedText,examples)
    suspend fun deleteVocabulary(vocabulary: Vocabulary) = myVocabularyDataSource.deleteVocabulary(vocabulary)
    suspend fun updateVocabulary(vocabulary: Vocabulary) = myVocabularyDataSource.updateVocabulary(vocabulary)
}