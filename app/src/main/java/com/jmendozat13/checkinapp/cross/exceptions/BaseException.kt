package com.jmendozat13.checkinapp.cross.exceptions

open class BaseException(override val message: String?) : Exception(message)
class UrlException(message: String?): BaseException(message)