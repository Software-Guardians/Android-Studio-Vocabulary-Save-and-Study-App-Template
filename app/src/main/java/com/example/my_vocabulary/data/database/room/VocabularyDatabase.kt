package com.example.my_vocabulary.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my_vocabulary.data.entity.Vocabulary

@Database(entities = [Vocabulary::class], version = 1)
abstract class VocabularyDatabase: RoomDatabase() {
    abstract fun getVocabularyDAO(): MyVocabularyDAO
}