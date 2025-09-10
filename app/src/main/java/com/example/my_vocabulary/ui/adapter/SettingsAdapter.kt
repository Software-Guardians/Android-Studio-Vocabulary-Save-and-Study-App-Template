package com.example.my_vocabulary.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_vocabulary.data.entity.Settings
import com.example.my_vocabulary.data.entity.Vocabulary
import com.example.my_vocabulary.databinding.SettingsCardViewBinding
import com.example.my_vocabulary.ui.viewmodel.SettingsViewModel
import com.google.android.material.snackbar.Snackbar

class SettingsAdapter(var mContext: Context,var vocabularyList: List<Settings>
,var viewModel: SettingsViewModel): RecyclerView.Adapter<SettingsAdapter.CardHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardHolder {
        var binding= SettingsCardViewBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardHolder(binding)

    }

    override fun onBindViewHolder(
        holder: CardHolder,
        position: Int
    ) {
        var d=holder.designBinding
        var settings=vocabularyList.get(position)
        d.textViewMain.text=settings.mainText
        d.textViewDetails.text=settings.details
        d.root.setOnClickListener {
            Snackbar.make(d.root,settings.message, Snackbar.LENGTH_SHORT).setAction("OK"){
                Snackbar.make(d.root,settings.message+" (2)", Snackbar.LENGTH_SHORT).setAction("OK"){
                    viewModel.removeAllDatas()
                }.show()
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return vocabularyList.size
    }

    inner class CardHolder(var designBinding: SettingsCardViewBinding): RecyclerView.ViewHolder(designBinding.root)
}