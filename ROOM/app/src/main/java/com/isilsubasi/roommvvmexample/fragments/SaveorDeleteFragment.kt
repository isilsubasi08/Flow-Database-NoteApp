package com.isilsubasi.roommvvmexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isilsubasi.roommvvmexample.databinding.FragmentSaveorDeleteBinding


class SaveorDeleteFragment : Fragment() {

    private var _binding: FragmentSaveorDeleteBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentSaveorDeleteBinding.inflate(inflater,container,false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.saveNote.setOnClickListener {
            
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }



}