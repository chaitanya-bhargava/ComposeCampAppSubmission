package com.example.instagramclone.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState : StateFlow<LoginUIState> = _uiState.asStateFlow()

    fun updateName(username : String,password:String) {
        _uiState.update { loginUIState ->
            loginUIState.copy(
                username = username,
                password = password
            )
        }
    }
}