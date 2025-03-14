package com.jmendozat13.checkinapp.domain.usecases

import com.jmendozat13.checkinapp.cross.commons.ResultState
import com.jmendozat13.checkinapp.domain.entities.UserAccount
import com.jmendozat13.checkinapp.domain.repositories.UserRepository
import javax.inject.Inject

class RegisterUserAccount @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(userAccount: UserAccount): ResultState<UserAccount> {
        return userRepository.register(userAccount)
    }
}