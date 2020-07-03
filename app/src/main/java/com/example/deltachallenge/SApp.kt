package com.example.deltachallenge

import android.app.Application
import com.example.deltachallenge.mvvm.PostViewModel
import com.example.deltachallenge.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class SApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@SApp)
            modules(moduleone)
        }
    }

    var moduleone = module {
        single { Repository() }
        viewModel { PostViewModel(get()) }
    }
}