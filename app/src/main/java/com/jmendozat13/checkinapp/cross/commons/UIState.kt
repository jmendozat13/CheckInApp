package com.jmendozat13.checkinapp.cross.commons

import com.jmendozat13.checkinapp.cross.exceptions.BaseException

sealed interface UIState<T> {
    class OnLoading<T> : UIState<T>
    data class OnSuccess<T>(val data: T) : UIState<T>
    data class OnError<T>(val exception: BaseException) : UIState<T>
}