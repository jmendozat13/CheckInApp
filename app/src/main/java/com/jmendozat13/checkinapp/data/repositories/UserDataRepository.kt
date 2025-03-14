package com.jmendozat13.checkinapp.data.repositories

import com.jmendozat13.checkinapp.cross.commons.ResultState
import com.jmendozat13.checkinapp.data.sources.UserNetworkDataSource
import com.jmendozat13.checkinapp.domain.entities.UserAccount
import com.jmendozat13.checkinapp.domain.repositories.UserRepository
import javax.inject.Inject

class UserDataRepository @Inject constructor(private val userNetworkDataSource: UserNetworkDataSource) :
    UserRepository {

    override suspend fun register(user: UserAccount): ResultState<UserAccount> {
        return userNetworkDataSource.register(user)
    }
}