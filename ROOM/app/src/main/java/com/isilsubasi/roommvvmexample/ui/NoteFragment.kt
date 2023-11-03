package com.isilsubasi.roommvvmexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isilsubasi.roommvvmexample.R
import com.isilsubasi.roommvvmexample.databinding.FragmentNoteBinding


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
            val fragment= SaveorDeleteFragment()
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