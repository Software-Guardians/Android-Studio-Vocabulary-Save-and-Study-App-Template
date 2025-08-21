package com.example.my_vocabulary.data.datasource

import com.example.my_vocabulary.data.database.room.MyVocabularyDAO
import com.example.my_vocabulary.data.entity.Vocabulary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyVocabularyDataSource(var myVocabularyDAO: MyVocabularyDAO) {
    suspend fun getByID(vocabularyID: Int): Vocabulary{
        return myVocabularyDAO.getByID(vocabularyID)
    }
    suspend fun insertVocabulary(id: Int, defaultLanguage: String, translateLanguage: String, text: String, translatedText: String,examples: String){
        val vocabulary=Vocabulary(id,defaultLanguage,translateLanguage,text,translatedText,examples)
        return myVocabularyDAO.insert(vocabulary)
    }
    suspend fun getAllVocabulary(): List<Vocabulary> = withContext(Dispatchers.IO){
        return@withContext myVocabularyDAO.getAll()
    }
    suspend fun deleteVocabulary(vocabulary: Vocabulary){
        return myVocabularyDAO.delete(vocabulary)
    }
    suspend fun updateVocabulary(vocabulary: Vocabulary){
        return myVocabularyDAO.update(vocabulary)
    }
}