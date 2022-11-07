@file:OptIn(ExperimentalLifecycleComposeApi::class)

package com.demoapp.memefon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demoapp.memefon.domain.MemefonViewModel
import com.demoapp.memefon.domain.models.PostUiState
import com.demoapp.memefon.ui.componets.PostCard
import com.demoapp.memefon.ui.componets.UserCardHeader
import com.demoapp.memefon.ui.theme.MemefonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MemefonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemefonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }

    }

    @Composable
    private fun HomeScreen() {
        val uiState: PostUiState by viewModel.uiState.collectAsStateWithLifecycle()
        HomeScreen(uiState = uiState)
    }

    @Composable
    private fun HomeScreen(uiState: PostUiState) {
        when (uiState) {
            is PostUiState.Loading -> Log.e("tagDemo", "Loading")
            is PostUiState.Success -> ShowHomeScreen(data = uiState)
            is PostUiState.Error -> Log.e("tagDemo", uiState.message)
        }
    }

    @Composable
    private fun ShowHomeScreen(data: PostUiState.Success) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(
                items = data.postList,
                key = { _, item -> item.id }
            ) { index, post ->
                UserCardHeader(
                    userPhoto = post.user.photo,
                    userName = post.user.username.orEmpty(),
                    postDate = post.createdAt,
                    category = post.category.name
                )
                PostCard(
                    title = post.title,
                    postImageUrl = post.imageUrl.orEmpty()
                )
                if (index < data.postList.lastIndex) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider(color = MaterialTheme.colorScheme.tertiary, thickness = 0.5.dp)
                }

            }
        }
    }

}