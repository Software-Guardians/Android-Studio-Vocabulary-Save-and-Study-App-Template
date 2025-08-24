package com.example.my_vocabulary.data.datasource

import com.example.my_vocabulary.data.database.room.MyVocabularyDAO
import com.example.my_vocabulary.data.entity.Vocabulary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyVocabularyDataSource(var myVocabularyDAO: MyVocabularyDAO) {
    suspend fun getByID(vocabularyID: Int): Vocabulary{
        return myVocabularyDAO.getByID(vocabularyID)
    }
    suspend fun insertVocabulary(defaultLanguage: String, translateLanguage: String, text: String, translatedText: String,examples: String,user_name: String){
        val vocabulary=Vocabulary(0,defaultLanguage,translateLanguage,text,translatedText,examples,user_name)
        return myVocabularyDAO.insert(vocabulary)
    }
    suspend fun getAllVocabulary(user_name: String): List<Vocabulary> = withContext(Dispatchers.IO){
        return@withContext myVocabularyDAO.getAllbyUser(user_name)
    }
    suspend fun deleteVocabulary(vocabulary: Vocabulary){
        return myVocabularyDAO.delete(vocabulary)
    }
    suspend fun updateVocabulary(vocabulary: Vocabulary){
        return myVocabularyDAO.update(vocabulary)
    }
}