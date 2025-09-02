package com.alexisserapio.appdisneylist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexisserapio.appdisneylist.R
import com.alexisserapio.appdisneylist.data.remote.DisneyAPI
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetails
import com.alexisserapio.appdisneylist.data.remote.model.CharacterDetailsResponse
import com.alexisserapio.appdisneylist.databinding.FragmentCharacterDetailsBinding
import com.alexisserapio.appdisneylist.util.Constants
import com.alexisserapio.appdisneylist.view.adapters.CharacterDetailsAdapter
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ARG_ID = "id"

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentCharacterDetailsBinding? = null

    private val binding get() = _binding!!

    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val charactersAPI = retrofit.create(DisneyAPI::class.java)

        fun llamadaAPI2(){
            val call: Call<CharacterDetailsResponse> = charactersAPI.getCharacterDetails(id)
            binding.pbLoading2.visibility = View.VISIBLE
            call.enqueue(object : Callback<CharacterDetailsResponse>{
                override fun onResponse(p0: Call<CharacterDetailsResponse>, response: Response<CharacterDetailsResponse>) {
                    Log.d("APPSLOGFRAGMENT", "CharacterFRAGMENT: $response")
                    binding.pbLoading2.visibility = View.INVISIBLE
                    if (response.isSuccessful) {
                        binding.CharactertextView.visibility = View.VISIBLE
                        val characterdetailsResponse = response.body()
                        val characterdetails = characterdetailsResponse?.data
                        Log.d("APPSLOGFRAGMENT", "CharacterFRAGMENT: $characterdetails")
                        binding.apply {
                            tvCharacterTitle.text = characterdetails?.name
                            Glide.with(binding.root.context)
                                .load(characterdetails?.imageUrl)
                                .placeholder(R.drawable.silueta)
                                .error(R.drawable.silueta)
                                .into(binding.ivCharacterImages)
                            RVFilms.layoutManager = LinearLayoutManager(requireActivity())
                            characterdetails?.let {
                                RVFilms.adapter = CharacterDetailsAdapter(mutableListOf(it)) // Pasa el objeto como lista de un solo elemento
                            }


                        }
                    }else {
                        Toast.makeText(
                            requireActivity(),
                            "No jalo",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(p0: Call<CharacterDetailsResponse>, t: Throwable) {
                    binding.pbLoading2.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireActivity(),
                        getString(R.string.ConnectionTimeFailure),
                        Toast.LENGTH_LONG
                    ).show()
                    Log.e("APPSLOG_FRAG", "Error: ${t.message}")
                    val botonreintentar2 = requireView().findViewById<Button>(R.id.button_retry2)
                    botonreintentar2.visibility = View.VISIBLE

                    botonreintentar2.setOnClickListener{
                        botonreintentar2.visibility = View.GONE
                        llamadaAPI2()
                    }

                }

            })
        }

        llamadaAPI2()

    }

    override fun onDestroy() {
        super.onDestroy()
                _binding = null
    }

    companion object {
        fun newInstance(id: String) =
            CharacterDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, id)
                }
            }
    }
}