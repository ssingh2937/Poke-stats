package com.sandhu.pokstats.model

//data class PokemonList(val results: List<PokemonData>)
//data class PokemonData(val name: String?, val url: String?)

data class PokemonList(val pokemon: List<PokemonData>)
data class PokemonData(val id: Int?, val num: String?, val name: String?, val img: String?)