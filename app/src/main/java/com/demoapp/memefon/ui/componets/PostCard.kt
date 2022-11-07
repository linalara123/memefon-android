package com.demoapp.memefon.ui.componets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.demoapp.memefon.ui.theme.MemefonTheme

@Preview
@Composable
private fun previewPostCard() {
    MemefonTheme {
        PostCard(
            title = "Meme title",
            postImageUrl = "https://memefon.s3.amazonaws.com/uploads/2022-10-28T07-22-50139Z-FB969C3D-5E84-4C9E-8760-3250B1C2A351.jpeg"
        )
    }
}


@Composable
fun PostCard(title: String, postImageUrl: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(postImageUrl)
                .build(),
            modifier = Modifier
                .wrapContentSize()
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.primary
                ),
            contentScale = ContentScale.FillHeight,
            contentDescription = null
        )
    }
}