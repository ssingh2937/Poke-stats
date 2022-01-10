package com.sandhu.pokstats

import android.app.Application
import com.sandhu.pokstats.di.DaggerRetroComponent
import com.sandhu.pokstats.di.RetroComponent
import com.sandhu.pokstats.di.RetrofitModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retrofitModule(RetrofitModule())
            .build()

    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }

}