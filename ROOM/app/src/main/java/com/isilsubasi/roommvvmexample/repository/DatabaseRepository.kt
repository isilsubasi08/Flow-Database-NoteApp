package com.isilsubasi.roommvvmexample.repository

import androidx.lifecycle.LiveData
import com.isilsubasi.roommvvmexample.db.NoteDAO
import com.isilsubasi.roommvvmexample.db.NoteDatabase
import com.isilsubasi.roommvvmexample.db.NoteEntity
import javax.inject.Inject


class DatabaseRepository @Inject constructor(private val dao : NoteDAO) {



    suspend fun saveNote(entity: NoteEntity) = dao.insert(entity)

    fun getAllNotes()=dao.getAllNotes()


}

/*
    Bir ağdan veri getirilip getirilemeyeceğine veya
    Veritabanında önbelleğe alınan sonuçların kullanıp kullanılmayacağına karar verme mantığını uygular.

 */