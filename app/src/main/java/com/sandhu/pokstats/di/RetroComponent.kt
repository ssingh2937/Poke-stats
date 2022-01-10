package com.sandhu.pokstats.di

import com.sandhu.pokstats.PokeListActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class])
interface RetroComponent {
    fun inject(pokeListActivityViewModel: PokeListActivityViewModel)
}