package com.alexisserapio.appdisneylist.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisserapio.appdisneylist.R
import com.alexisserapio.appdisneylist.data.remote.DisneyAPI
import com.alexisserapio.appdisneylist.data.remote.model.CharacterResponse
import com.alexisserapio.appdisneylist.databinding.FragmentCharacterListBinding
import com.alexisserapio.appdisneylist.util.Constants
import com.alexisserapio.appdisneylist.view.adapters.CharactersAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentCharacterListBinding.inflate(
                inflater,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val charactersAPI = retrofit.create(DisneyAPI::class.java)

        fun llamadaAPI(){
            // Llamada a la API con el parámetro adecuado
            val call: Call<CharacterResponse> = charactersAPI.getCharacters(7438)
            binding.pbLoading.visibility = View.VISIBLE
            binding.buttonRetry.visibility = View.INVISIBLE
            call.enqueue(object : Callback<CharacterResponse> {

                override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                    binding.pbLoading.visibility = View.INVISIBLE
                    if (response.isSuccessful) {
                        val characterResponse = response.body()
                        val characters = characterResponse?.data
                        Log.d("APPSLOG", characters.toString())

                        binding.apply {
                            RVCharacters.layoutManager = LinearLayoutManager(requireActivity())
                            RVCharacters.adapter = characters?.let {
                                CharactersAdapter(characters) { character2 ->
                                    Log.d("APPSLOG2", "Character ID: $character2")
                                    character2._id?.let{ id->
                                        requireActivity().supportFragmentManager.beginTransaction()
                                            .replace(R.id.FragmentContainer, CharacterDetailsFragment.newInstance(character2._id.toString()))
                                            .addToBackStack(null)
                                            .commit()
                                            Log.d("APPSLOG3", "Correct CharacterID: ${character2._id.toString()}")


                                    }
                                }
                            }
                        }


                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "No jalo",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                    binding.pbLoading.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.ConnectionTimeFailure),
                        Toast.LENGTH_LONG
                    ).show()
                    Log.e("APPSLOG", "Error: ${t.message}")

                    val boton_reintentar = requireView().findViewById<Button>(R.id.button_retry)
                    boton_reintentar.visibility = View.VISIBLE

                    boton_reintentar.setOnClickListener{
                        boton_reintentar.visibility = View.GONE
                        llamadaAPI()
                    }
                }

            })

        }

        llamadaAPI()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}