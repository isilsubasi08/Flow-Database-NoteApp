package com.isilsubasi.roommvvmexample.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.isilsubasi.roommvvmexample.utils.Contants.NOTE_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteEntity : NoteEntity)

    @Query("SELECT * FROM $NOTE_TABLE")
    fun getAllNotes() : Flow<MutableList<NoteEntity>>

}