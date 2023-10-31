package com.clarkelamothe.recetapp.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiEvent> : ViewModel() {
    private val eventChannel = Channel<UiEvent>()
    val eventFlow = eventChannel.receiveAsFlow()

    fun sendEvent(vararg event: UiEvent) {
        viewModelScope.launch {
            event.forEach {
                eventChannel.send(it)
            }
        }
    }
}