package com.isilsubasi.roommvvmexample.viewmodel

import androidx.lifecycle.ViewModel
import com.isilsubasi.roommvvmexample.model.NoteEntity
import com.isilsubasi.roommvvmexample.repository.NoteRepository

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {


    suspend fun insertNote(noteEntity: NoteEntity)=repository.insertNotes(noteEntity)

    suspend fun updateNote(noteEntity: NoteEntity)=repository.updateNotes(noteEntity)

    suspend fun deleteNoteById(id : Int)=repository.deleteNotesById(id)

    suspend fun deleteNote()=repository.deleteAllNotes()

    fun getAllNotes()=repository.gelAllNotes()




}