package com.jmendozat13.checkinapp.cross.commons

import com.jmendozat13.checkinapp.cross.exceptions.BaseException


sealed interface ResultState<T> {
    data class Success<T>(val data: T) : ResultState<T>
    data class Error<T>(val exception: BaseException) : ResultState<T>
}