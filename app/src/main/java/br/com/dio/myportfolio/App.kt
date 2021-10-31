package br.com.dio.myportfolio

import android.app.Application
import br.com.dio.myportfolio.data.di.DataModule
import br.com.dio.myportfolio.domain.di.DomainModule
import br.com.dio.myportfolio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}