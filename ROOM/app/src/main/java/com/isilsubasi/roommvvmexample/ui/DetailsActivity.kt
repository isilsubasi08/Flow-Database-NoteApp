package com.isilsubasi.roommvvmexample.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.graphics.toColorInt
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar
import com.isilsubasi.roommvvmexample.R
import com.isilsubasi.roommvvmexample.databinding.ActivityDetailsBinding
import com.isilsubasi.roommvvmexample.db.NoteEntity
import com.isilsubasi.roommvvmexample.viewmodel.DatabaseViewModel
import com.thebluealliance.spectrum.SpectrumPalette
import com.yahiaangelo.markdownedittext.MarkdownEditText
import com.yahiaangelo.markdownedittext.MarkdownStylesBar
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
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
    private var noteColor=-1
    private var noteDate=""

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        noteDate=getCurrentDate()
        binding.saveNote.setOnClickListener {
            noteTitle=binding.etTitle.text.toString()
            noteDescription=binding.etNoteContent.text.toString()

            if (noteTitle.isEmpty() || noteDescription.isEmpty()){
                Snackbar.make(it,"Title and Description cannot be empty",Snackbar.LENGTH_SHORT).show()
            }else{

                entity.Id=noteId
                entity.title=noteTitle
                entity.description=noteDescription
                entity.color=noteColor
                entity.date=noteDate

                viewModel.saveNote(entity)
                binding.etTitle.setText("")
                binding.etNoteContent.setText("")
                finish()
            }


        }

        binding.fabColorPick.setOnClickListener {
            openBottomSheetDialog()
        }

        binding.etNoteContent.setOnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.bottomBar.visibility = View.VISIBLE
                    val markdownEditText = findViewById<MarkdownEditText>(R.id.etNoteContent)
                    val stylesBar = findViewById<MarkdownStylesBar>(R.id.styleBar)
                    markdownEditText.setStylesBar(stylesBar)

                }
            }

            return@setOnTouchListener false
        }

        binding.lastEdited.text=getCurrentDate()



        }
    private fun openBottomSheetDialog(){

        val bottomSheetDialog = BottomSheetDialog(this,R.style.BottomSheetStyle)
        val bottomSheetView=LayoutInflater.from(this).inflate(
            R.layout.bottom_sheet_layout,
            binding.root.findViewById(R.id.bottomSheetParent) as? MaterialCardView
        )
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
        val spectrumPalette=bottomSheetView.findViewById<SpectrumPalette>(R.id.colorPicker)
        spectrumPalette.setOnColorSelectedListener { color ->
            noteColor=color
            binding.noteContentFragmentParent.setBackgroundColor(color)
        }


    }
    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        return dateFormat.format(calendar.time)
    }

    }




