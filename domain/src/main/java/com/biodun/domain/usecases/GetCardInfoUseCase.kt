package com.biodun.domain.usecases

import com.biodun.core.result.ResultOrError
import com.biodun.core.result.Failure
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.repositories.CardInfoRepository
import javax.inject.Inject

class GetCardInfoUseCase @Inject constructor(private val cardInfoRepository: CardInfoRepository) {

    suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoEntity> =
        cardInfoRepository.getCardInfo(cardNumber)
}
