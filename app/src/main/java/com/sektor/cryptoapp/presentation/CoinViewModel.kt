package com.sektor.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.sektor.cryptoapp.domain.GetCoinInfoListUseCase
import com.sektor.cryptoapp.domain.GetCoinInfoUseCase
import com.sektor.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}