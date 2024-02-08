package com.sektor.cryptoapp.di

import android.app.Application
import com.sektor.cryptoapp.data.database.AppDatabase
import com.sektor.cryptoapp.data.database.CoinInfoDao
import com.sektor.cryptoapp.data.network.ApiFactory
import com.sektor.cryptoapp.data.network.ApiService
import com.sektor.cryptoapp.data.repository.CoinRepositoryImpl
import com.sektor.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}