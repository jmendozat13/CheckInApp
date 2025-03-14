package com.jmendozat13.checkinapp.di

import com.jmendozat13.checkinapp.data.repositories.UserDataRepository
import com.jmendozat13.checkinapp.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CheckInAppModule {
    @Binds
    fun bindUserRepository(userDataRepository: UserDataRepository): UserRepository
}