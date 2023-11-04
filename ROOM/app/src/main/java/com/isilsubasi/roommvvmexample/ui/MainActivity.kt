package com.isilsubasi.roommvvmexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            innerFab.setOnClickListener {
                val intent= Intent(this@MainActivity,DetailsActivity::class.java)
                startActivity(intent)
            }

            rvNote.addOnScrollListener(object : RecyclerView.OnScrollListener(){

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    // Scroll down
                    if (dy > 20 && innerFab.isExtended) {
                        innerFab.shrink()
                    }

                    // Scroll up
                    if (dy < -20 && !innerFab.isExtended) {
                        innerFab.extend()
                    }

                    // At the top
                    if (!recyclerView.canScrollVertically(-1)) {
                        innerFab.extend()
                    }
                }


            })

        }

        viewModel.getAllNotes()
        viewModel.noteList.observe(this@MainActivity){
            when(it.status){
                DataStatus.Status.SUCCESS -> {
                  _binding.emptyBody.visibility=View.GONE
                  noteAdapter.differ.submitList(it.data)
                  _binding.rvNote.apply {
                      layoutManager=LinearLayoutManager(this@MainActivity)
                      adapter=noteAdapter
                  }
                }
                DataStatus.Status.ERROR -> {
                    Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }


        }




    }


}