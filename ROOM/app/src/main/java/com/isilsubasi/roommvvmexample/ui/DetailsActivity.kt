package com.isilsubasi.roommvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.isilsubasi.roommvvmexample.R
import com.isilsubasi.roommvvmexample.databinding.ActivityDetailsBinding
import com.isilsubasi.roommvvmexample.db.NoteEntity
import com.isilsubasi.roommvvmexample.viewmodel.DatabaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    @Inject
    lateinit var entity: NoteEntity
    private val viewModel : DatabaseViewModel by viewModels()


    private var noteId = 0
    private var noteTitle =""
    private var noteDescription=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.saveNote.setOnClickListener {
            noteTitle=binding.etTitle.text.toString()
            noteDescription=binding.etNoteContent.text.toString()

            if (noteTitle.isEmpty() || noteDescription.isEmpty()){
                Snackbar.make(it,"Title and Description cannot be empty",Snackbar.LENGTH_SHORT).show()
            }else{

                entity.Id=noteId
                entity.title=noteTitle
                entity.description=noteDescription

                viewModel.saveNote(entity)
                binding.etTitle.setText("")
                binding.etNoteContent.setText("")
                finish()
            }


        }


    }
}