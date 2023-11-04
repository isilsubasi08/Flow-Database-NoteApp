package com.isilsubasi.roommvvmexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.isilsubasi.roommvvmexample.adapter.NoteAdapter
import com.isilsubasi.roommvvmexample.databinding.ActivityMainBinding
import com.isilsubasi.roommvvmexample.utils.DataStatus
import com.isilsubasi.roommvvmexample.viewmodel.DatabaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding:ActivityMainBinding

    @Inject
    lateinit var noteAdapter: NoteAdapter
    private val viewModel : DatabaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.apply {
            addNoteFab.setOnClickListener {
                val intent= Intent(this@MainActivity,DetailsActivity::class.java)
                startActivity(intent)
            }
        }

        viewModel.getAllNotes()
        viewModel.noteList.observe(this@MainActivity){
            when(it.status){
                DataStatus.Status.LOADING -> {

                }
                DataStatus.Status.SUCCESS -> {
                    _binding.emptyBody.visibility=View.GONE
                  noteAdapter.differ.submitList(it.data)
                  _binding.rvNote.apply {
                      layoutManager=LinearLayoutManager(this@MainActivity)
                      adapter=noteAdapter
                  }
                }
                DataStatus.Status.ERROR -> {}
            }


        }




    }


}