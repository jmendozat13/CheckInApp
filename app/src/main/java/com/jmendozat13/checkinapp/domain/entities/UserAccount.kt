package com.jmendozat13.checkinapp.domain.entities

data class UserAccount(
    val id: String = "",
    val name: String,
    val email: String,
    val phoneNumber: String
)