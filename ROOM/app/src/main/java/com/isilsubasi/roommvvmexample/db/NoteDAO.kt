package com.isilsubasi.roommvvmexample.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.isilsubasi.roommvvmexample.model.NoteEntity

@Dao
interface NoteDAO {

    @Insert
    suspend fun insert(noteEntity : NoteEntity)

    @Update
    suspend fun update(noteEntity : NoteEntity)

    @Query("DELETE FROM note_table")
    suspend fun deleteAllNotes()

    @Query("DELETE FROM note_table WHERE id= :id")
    suspend fun deleteNoteById(id: Int)

    @Query("SELECT * FROM note_table ORDER BY priority DESC" )
    fun getAllNotes() : LiveData<List<NoteEntity>>


}