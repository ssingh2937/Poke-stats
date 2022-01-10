package com.sandhu.pokstats.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {
    //private val baseURL = "https://pokeapi.co/api/v2/"
    private val baseURL = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/"

    @Singleton
    @Provides
    fun getRetroServiceInterface(retrofit: Retrofit): RetroServiceInterface{
        return retrofit.create(RetroServiceInterface::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}