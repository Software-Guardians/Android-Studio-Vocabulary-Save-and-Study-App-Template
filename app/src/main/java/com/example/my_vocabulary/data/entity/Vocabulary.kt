package com.example.my_vocabulary.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "vocabulary")
data class Vocabulary(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "default_language")
    val default_language: String="",
    @ColumnInfo(name = "translate_language")
    val translate_language: String="",
    @ColumnInfo(name = "text")@NotNull
    val text: String="",
    @ColumnInfo(name = "translated_text")@NotNull
    val translated_text: String="",
    @ColumnInfo(name = "examples")
    val examples: String,
    @ColumnInfo(name="user_name")
    val user_name: String
): Serializable {
}