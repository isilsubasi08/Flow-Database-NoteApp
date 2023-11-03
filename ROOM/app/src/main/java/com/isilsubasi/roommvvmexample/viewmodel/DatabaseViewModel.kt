package com.isilsubasi.roommvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isilsubasi.roommvvmexample.db.NoteEntity
import com.isilsubasi.roommvvmexample.repository.DatabaseRepository
import com.isilsubasi.roommvvmexample.utils.DataStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DatabaseViewModel @Inject constructor(private val repository: DatabaseRepository) : ViewModel(){


        private val _noteList=MutableLiveData<DataStatus<List<NoteEntity>>> ()
        val noteList : LiveData<DataStatus<List<NoteEntity>>>
        get() = _noteList

    fun saveNote(entity: NoteEntity) = viewModelScope.launch {
        repository.saveNote(entity)
    }


    fun getAllNotes() = viewModelScope.launch {
        repository.getAllNotes()
            .catch { _noteList.postValue(DataStatus.error(it.message.toString())) }
            .collect{_noteList.postValue(DataStatus.success(it,it.isEmpty()))}
    }

}

