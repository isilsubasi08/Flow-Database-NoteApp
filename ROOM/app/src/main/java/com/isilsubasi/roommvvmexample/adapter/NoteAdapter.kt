package com.isilsubasi.roommvvmexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.isilsubasi.roommvvmexample.databinding.NoteItemLayoutBinding
import com.isilsubasi.roommvvmexample.db.NoteEntity
import javax.inject.Inject

class NoteAdapter @Inject constructor() : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private lateinit var binding: NoteItemLayoutBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       binding=NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
    }

    override fun getItemCount(): Int =differ.currentList.size

    inner class ViewHolder() : RecyclerView.ViewHolder(binding.root){
        fun setData(item : NoteEntity){
            binding.apply {
                Log.e("isil",item.title)
                noteItemTitle.text=item.title
                noteContentItem.text=item.description
            }
        }

    }

    private val differCallback = object :DiffUtil.ItemCallback<NoteEntity>(){
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.Id==newItem.Id
        }

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
           return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

}