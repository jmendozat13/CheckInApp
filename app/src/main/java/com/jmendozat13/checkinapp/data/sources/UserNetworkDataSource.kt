package com.jmendozat13.checkinapp.data.sources

import com.jmendozat13.checkinapp.cross.commons.ResultState
import com.jmendozat13.checkinapp.domain.entities.UserAccount
import javax.inject.Inject

class UserNetworkDataSource @Inject constructor() {

    suspend fun register(userAccount: UserAccount): ResultState<UserAccount> {
        return ResultState.Success(userAccount.copy(id = "123456"))
    }
}