package com.jmendozat13.checkinapp.delivery.viewmodels

import androidx.lifecycle.ViewModel
import com.jmendozat13.checkinapp.delivery.navigation.ScreenNavigationGraph
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

open class BaseViewModel : ViewModel() {
    protected val mNavigationShareFlow: MutableSharedFlow<ScreenNavigationGraph> by lazy { MutableSharedFlow() }
    val navigation = mNavigationShareFlow.asSharedFlow()
}