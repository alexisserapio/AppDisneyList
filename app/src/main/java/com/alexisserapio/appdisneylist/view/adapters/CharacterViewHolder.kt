package com.alexisserapio.appdisneylist.view.adapters

import androidx.recyclerview.widget.RecyclerView
import com.alexisserapio.appdisneylist.R
import com.alexisserapio.appdisneylist.data.remote.model.Character
import com.alexisserapio.appdisneylist.databinding.CharacterElementBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class CharacterViewHolder(
    private val binding: CharacterElementBinding
):RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character){
        binding.tvTitle.text = character.name

        fun formatDateLegacy(dateString: String): String {
            // Parsear la fecha en formato ISO 8601
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("UTC") // La fecha está en UTC

            // Parsear la fecha
            val date = inputFormat.parse(dateString)

            // Determinar el formato basado en el Locale
            val outputFormat = when (Locale.getDefault()) {
                Locale.US -> SimpleDateFormat("MMMM d, yyyy", Locale.US) // Ej: April 12, 2021
                else -> SimpleDateFormat(("d 'de' MMMM 'de' yyyy"), Locale.getDefault()) // Formato por defecto
            }

            // Formatear y devolver la fecha
            return date?.let { outputFormat.format(it) } ?: "Fecha inválida"
        }

        val fechaFormato = character.createdAt?.let { formatDateLegacy(it) }

        binding.tvDate.text = fechaFormato
        Glide.with(binding.root.context)
            .load(character.imageUrl)
            .placeholder(R.drawable.silueta)
            .error(R.drawable.silueta)
            .into(binding.ivThumbnail)
    }
}