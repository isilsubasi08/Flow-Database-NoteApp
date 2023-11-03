package com.isilsubasi.roommvvmexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
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
