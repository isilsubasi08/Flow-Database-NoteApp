package com.isilsubasi.roommvvmexample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isilsubasi.roommvvmexample.repository.NoteRepository
import java.lang.Exception

class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            val constructor=modelClass.getDeclaredConstructor(NoteRepository::class.java)
            return constructor.newInstance(repository)


        }catch (e : Exception){
            Log.e("isil", "create: ${e.message} " )
        }
        return super.create(modelClass)
    }
}