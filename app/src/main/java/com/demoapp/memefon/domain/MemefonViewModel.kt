package com.demoapp.memefon.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demoapp.memefon.data.MemefonDataSource
import com.demoapp.memefon.data.MemefonLocalDataSource
import com.demoapp.memefon.domain.models.PostUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MemefonViewModel @Inject constructor(
    private val memefonDataSource: MemefonDataSource
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<PostUiState> = _uiState

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            val result = try {
                val response = memefonDataSource.loadData()
                if (response.status.equals("success", true)) {
                    PostUiState.Success(response.data)
                } else {
                    PostUiState.Error("Server error --> ${response.status}")
                }
            } catch (e: Exception) {
                PostUiState.Error("Network request failed")
            }
            _uiState.value = result
        }
    }

}