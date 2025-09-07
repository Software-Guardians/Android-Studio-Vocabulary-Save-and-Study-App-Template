package com.example.my_vocabulary.data.repo

import com.example.my_vocabulary.data.datasource.MyVocabularyDataSource
import com.example.my_vocabulary.data.entity.Vocabulary
import javax.inject.Inject

class MyVocabularyRepository @Inject constructor(var myVocabularyDataSource: MyVocabularyDataSource) {
    suspend fun getVocabulary(id: Int) = myVocabularyDataSource.getByID(id)
    fun getAllVocabulary(user_name: String) = myVocabularyDataSource.getAllVocabulary(user_name)
    suspend fun insertVocabulary(defaultLanguage: String, translateLanguage: String, text: String, translatedText: String,examples: String,user_name: String) = myVocabularyDataSource.insertVocabulary(defaultLanguage,translateLanguage,text,translatedText,examples,user_name)
    suspend fun deleteVocabulary(vocabulary: Vocabulary) = myVocabularyDataSource.deleteVocabulary(vocabulary)
    suspend fun updateVocabulary(vocabulary: Vocabulary) = myVocabularyDataSource.updateVocabulary(vocabulary)
}