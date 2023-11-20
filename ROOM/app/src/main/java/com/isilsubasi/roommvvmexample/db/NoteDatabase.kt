package com.isilsubasi.roommvvmexample.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version=3)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDao() : NoteDAO

}
