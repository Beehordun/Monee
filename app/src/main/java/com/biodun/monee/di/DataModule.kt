package com.biodun.monee.di

import com.biodun.data.repositories.CardInfoRepositoryImpl
import com.biodun.domain.repositories.CardInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindCardInfoRepository(cardInfoRepositoryImpl: CardInfoRepositoryImpl): CardInfoRepository

}
