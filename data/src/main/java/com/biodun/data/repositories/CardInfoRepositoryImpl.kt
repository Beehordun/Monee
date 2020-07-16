package com.biodun.data.repositories

import com.biodun.core.result.ResultOrError
import com.biodun.core.result.Failure
import com.biodun.core.result.map
import com.biodun.data.mapper.CardInfoEntityMapper
import com.biodun.data.remote.RemoteDataSource
import com.biodun.domain.models.CardInfoEntity
import com.biodun.domain.repositories.CardInfoRepository
import javax.inject.Inject

class CardInfoRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val cardInfoEntityMapper: CardInfoEntityMapper
) : CardInfoRepository {

    override suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoEntity> =
         remoteDataSource.getCardInfo(cardNumber).map { cardInfoEntityMapper.mapToEntity(it) }
}
