package com.isilsubasi.roommvvmexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.isilsubasi.roommvvmexample.R
import com.isilsubasi.roommvvmexample.databinding.FragmentNoteBinding
import com.isilsubasi.roommvvmexample.db.NoteDatabase
import com.isilsubasi.roommvvmexample.repository.NoteRepository
import com.isilsubasi.roommvvmexample.viewmodel.NoteViewModel
import com.isilsubasi.roommvvmexample.viewmodel.NoteViewModelFactory


class NoteFragment : Fragment() {

    private var _binding:FragmentNoteBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater,container,false)
        val view = binding.root
        _binding!!.addNoteFab.setOnClickListener {
            val fragment=SaveorDeleteFragment()
            val transaction=fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragment,fragment)?.commit()
        }
        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}