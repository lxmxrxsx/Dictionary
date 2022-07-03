package com.example.dictionary.feature_dictionary.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.WordInfoBinding
import com.example.dictionary.feature_dictionary.domain.model.WordInfo

class WordInfoAdapter(
    private val view: View,
    private val list: List<WordInfo>
    ) : RecyclerView.Adapter<WordInfoAdapter.WordInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordInfoViewHolder {
        return WordInfoViewHolder(
            WordInfoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: WordInfoViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvWord.text = item.word
        holder.binding.tvPhonetic.text = item.phonetic
        holder.binding.tvMeaning.text = item.meanings.firstOrNull()?.definitions?.firstOrNull()?.definition
    }

    override fun getItemCount(): Int = list.size

    class WordInfoViewHolder( val binding: WordInfoBinding) : RecyclerView.ViewHolder(binding.root)



}