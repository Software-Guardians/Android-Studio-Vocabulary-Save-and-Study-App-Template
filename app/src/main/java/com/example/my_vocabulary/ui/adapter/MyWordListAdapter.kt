package com.example.my_vocabulary.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.databinding.MyWordListCardViewBinding
import com.example.my_vocabulary.ui.viewmodel.MyWordListViewModel

class MyWordListAdapter(var mContext: Context,var vocabularyList: List<Vocabulary> ,var viewModel: MyWordListViewModel):
    RecyclerView.Adapter<MyWordListAdapter.cardHolder>(){
    fun setData(newList: List<Vocabulary>){
        vocabularyList=newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): cardHolder {
        var binding= MyWordListCardViewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return cardHolder(binding)
    }

    override fun onBindViewHolder(
        holder: cardHolder,
        position: Int
    ) {
        val vocabulary=vocabularyList.get(position)
        val t=holder.tasarimBinding
        t.textViewWord.text=vocabulary.text
        t.textViewMeaning.text=vocabulary.translated_text
    }

    override fun getItemCount(): Int {
        return vocabularyList.size
    }

    inner class cardHolder(var tasarimBinding: MyWordListCardViewBinding): RecyclerView.ViewHolder(tasarimBinding.root)
}