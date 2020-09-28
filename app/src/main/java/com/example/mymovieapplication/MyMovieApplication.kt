package com.example.mymovieapplication

import android.app.Application
import com.example.mymovieapplication.MovieDetail.MovieDetailViewModelFactory
import com.example.mymovieapplication.data.network.ApiInterface
import com.example.mymovieapplication.data.network.NetworkConnectionInterceptor
import com.example.mymovieapplication.data.repositories.HomeRepository
import com.example.mymovieapplication.data.repositories.MovieDetailRepository
import com.example.mymovieapplication.mainScreen.MainActivityViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyMovieApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyMovieApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiInterface(instance()) }
        bind() from singleton { HomeRepository(instance()) }
        bind() from singleton { MainActivityViewModelFactory(instance()) }
        bind() from singleton { MovieDetailRepository(instance()) }
        bind() from provider { MovieDetailViewModelFactory(instance()) }

    }
}