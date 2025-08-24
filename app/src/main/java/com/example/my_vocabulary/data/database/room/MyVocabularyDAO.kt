package com.example.my_vocabulary.data.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.my_vocabulary.data.entity.Vocabulary

@Dao
interface MyVocabularyDAO {
    @Insert
    suspend fun insert(vocabulary: Vocabulary)
    @Query("Select * from vocabulary where user_name=:user_name")
    suspend fun getAllbyUser(user_name: String): List<Vocabulary>
    @Delete
    suspend fun delete(vocabulary: Vocabulary)
    @Query("Select * from vocabulary where id=:id")
    suspend fun getByID(id:Int): Vocabulary
    @Update
    suspend fun update(vocabulary: Vocabulary)
}