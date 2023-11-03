package com.isilsubasi.roommvvmexample.repository

import androidx.lifecycle.LiveData
import com.isilsubasi.roommvvmexample.db.NoteDatabase
import com.isilsubasi.roommvvmexample.model.NoteEntity


class NoteRepository(private val noteDatabase: NoteDatabase) {

    suspend fun insertNotes(noteEntity : NoteEntity) = noteDatabase.getNoteDao().insert(noteEntity)

    suspend fun updateNotes(noteEntity: NoteEntity)=noteDatabase.getNoteDao().update(noteEntity)

    suspend fun deleteNotesById(id :Int)=noteDatabase.getNoteDao().deleteNoteById(id)

    suspend fun deleteAllNotes()=noteDatabase.getNoteDao().deleteAllNotes()

    fun gelAllNotes() : LiveData<List<NoteEntity>> = noteDatabase.getNoteDao().getAllNotes()



}

/*
    Bir ağdan veri getirilip getirilemeyeceğine veya
    Veritabanında önbelleğe alınan sonuçların kullanıp kullanılmayacağına karar verme mantığını uygular.

 */