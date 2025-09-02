package com.alexisserapio.appdisneylist.view.adapters

import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.RecyclerView
import com.alexisserapio.appdisneylist.R
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetails
import com.alexisserapio.appdisneylist.databinding.FilmsElementBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class CharacterDetailsViewHolder(
    private val binding: FilmsElementBinding
):RecyclerView.ViewHolder(binding.root) {

    fun bind(characterDetails: CharacterDetails){
        var filmsList = characterDetails.films.joinToString(", ") // Convirtiendo la lista a un string separado por comas
        if(filmsList.isEmpty()){
            filmsList = binding.root.context.getString(R.string.NoFilms)
        }
        binding.tvFilmTitle.text = filmsList
        //binding.tvFilmTitle.text = characterDetails.films.toString()

    }
}