package com.jmendozat13.checkinapp.domain.repositories

import com.jmendozat13.checkinapp.cross.commons.ResultState
import com.jmendozat13.checkinapp.domain.entities.UserAccount

interface UserRepository {
    suspend fun register(user: UserAccount): ResultState<UserAccount>
}