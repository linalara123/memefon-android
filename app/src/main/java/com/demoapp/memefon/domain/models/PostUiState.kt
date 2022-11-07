package com.demoapp.memefon.domain.models

import com.demoapp.memefon.data.models.Post

sealed class PostUiState {
    data class Success(val postList: List<Post>) : PostUiState()
    data class Error(val message: String) : PostUiState()
    object Loading : PostUiState()
}