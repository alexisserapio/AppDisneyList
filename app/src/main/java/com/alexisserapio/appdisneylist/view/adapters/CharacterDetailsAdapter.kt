package com.alexisserapio.appdisneylist.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetails
import com.alexisserapio.appdisneylist.databinding.FilmsElementBinding

class CharacterDetailsAdapter(
    private val characterDetails: MutableList<CharacterDetails>,
):RecyclerView.Adapter<CharacterDetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterDetailsViewHolder {

        val binding = FilmsElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = characterDetails.size

    override fun onBindViewHolder(holder: CharacterDetailsViewHolder, position: Int) {
        val characterDetails = characterDetails[position]

        holder.bind(characterDetails)
    }
}