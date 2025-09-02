package com.alexisserapio.appdisneylist.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.recyclerview.widget.RecyclerView
import com.alexisserapio.appdisneylist.data.remote.model.Character
import com.alexisserapio.appdisneylist.databinding.CharacterElementBinding

class CharactersAdapter(
    private val characters: MutableList<Character>,
    private val onCharacterClick: (Character) -> Unit
):RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]

        holder.bind(character)

        holder.itemView.setOnClickListener{
            onCharacterClick(character)
        }
    }
}