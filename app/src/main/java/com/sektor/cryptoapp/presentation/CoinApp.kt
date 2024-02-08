package com.sektor.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.sektor.cryptoapp.data.workers.CoinWorkerFactory
import com.sektor.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

//dont forget to add this to android manifest
// Configuration is for dependency injection into Worker
class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: CoinWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    // TO make this works we need to add to manifest tag <provider>
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}