package com.sandhu.pokstats.di

import com.sandhu.pokstats.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    //@GET("pokemon")
    //fun getAllPokemon(@Query("limit") limit: String): Call<PokemonList>

    @GET("pokedex.json")
    fun getAllPokemon(): Call<PokemonList>


}