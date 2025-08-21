package com.example.my_vocabulary.di

import android.content.Context
import androidx.room.Room
import com.example.my_vocabulary.data.database.room.MyVocabularyDAO
import com.example.my_vocabulary.data.database.room.VocabularyDatabase
import com.example.my_vocabulary.data.datasource.MyVocabularyDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataSource(vocabularyDAO: MyVocabularyDAO): MyVocabularyDataSource{
        return MyVocabularyDataSource(vocabularyDAO)
    }
    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context): MyVocabularyDAO
    {
        val database= Room.databaseBuilder(context, VocabularyDatabase::class.java,"vocabulary.db").build()
        return database.getVocabularyDAO()
    }
}