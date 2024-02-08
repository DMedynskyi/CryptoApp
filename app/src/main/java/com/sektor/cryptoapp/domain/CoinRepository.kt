package com.sektor.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.sektor.cryptoapp.domain.CoinInfo

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}
