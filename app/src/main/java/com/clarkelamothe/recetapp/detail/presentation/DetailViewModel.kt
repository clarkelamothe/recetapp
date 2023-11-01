package com.clarkelamothe.recetapp.detail.presentation

import com.clarkelamothe.recetapp.core.ui.BaseViewModel
import com.clarkelamothe.recetapp.detail.presentation.model.DetailUiEvent

class DetailViewModel : BaseViewModel<DetailUiEvent>() {
    fun fabClicked() = sendEvent(DetailUiEvent.OnFabClicked)
}

