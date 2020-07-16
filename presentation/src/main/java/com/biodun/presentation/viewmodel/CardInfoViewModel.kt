package com.biodun.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biodun.core.result.Failure
import com.biodun.core.result.map
import com.biodun.domain.usecases.GetCardInfoUseCase
import com.biodun.presentation.ViewState
import com.biodun.presentation.mapper.CardInfoMapper
import com.biodun.presentation.model.CardInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardInfoViewModel @ViewModelInject constructor(
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val cardInfoMapper: CardInfoMapper
) : ViewModel() {

    private var _cardInfoLiveData = MutableLiveData<ViewState<CardInfo>>()
    var cardInfoLiveData: LiveData<ViewState<CardInfo>> = _cardInfoLiveData

    fun getCardInfo(cardNumber: String) {
        _cardInfoLiveData.postValue(ViewState.Loading())

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getCardInfoUseCase.getCardInfo(cardNumber).map {
                    cardInfoMapper.mapToCardInfo(it)
                }.fold(::handleGetCardInfoFailure, ::handleGetCardInfoSuccess)
            }
        }
    }

    private fun handleGetCardInfoFailure(failure: Failure) =
        _cardInfoLiveData.postValue(ViewState.Error(failure))


    private fun handleGetCardInfoSuccess(cardInfo: CardInfo) =
        _cardInfoLiveData.postValue(ViewState.Success(cardInfo))

}
