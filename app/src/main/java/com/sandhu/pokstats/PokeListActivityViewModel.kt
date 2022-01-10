package com.sandhu.pokstats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sandhu.pokstats.di.RetroServiceInterface
import com.sandhu.pokstats.model.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PokeListActivityViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var mService: RetroServiceInterface
    private lateinit var liveDataList: MutableLiveData<PokemonList>

    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<PokemonList>{
        return liveDataList
    }

    fun makeApiCall(){
        val call: Call<PokemonList>? = mService.getAllPokemon()
        call?.enqueue(object: Callback<PokemonList>{
            override fun onFailure(call: Call<PokemonList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                if(response.isSuccessful){
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }
            }
        })
    }
}