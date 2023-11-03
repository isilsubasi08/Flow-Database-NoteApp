package com.isilsubasi.roommvvmexample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.isilsubasi.roommvvmexample.utils.Contants.NOTE_TABLE

@Entity(tableName = NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var Id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String="",

    @ColumnInfo(name = "description")
    var description: String="",

    @ColumnInfo(name = "priority")
    var priority: Int=0
)

//Entity -> Veri tabanındaki tablo adını belirtiyoruz.
//PrimaryKey -> Her nesnenin birbirinden farklı id oluşturmamızı sağlıyor.
//ColumnInfo -> Sütunlarımızı bu etiket ile oluşturuyoruz.
