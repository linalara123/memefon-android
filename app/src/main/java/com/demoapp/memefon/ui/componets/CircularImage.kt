package com.demoapp.memefon.ui.componets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.demoapp.memefon.ui.theme.MemefonTheme


@Preview
@Composable
private fun PreviewImageCircle() {
    MemefonTheme() {
        CircularImage(imageUrl = "https://memefon.s3.amazonaws.com/uploads/2021-08-16T03-41-24031Z-nmpxfqthkvngtt8qmax5.octet-stream")
    }
}

@Composable
fun CircularImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        modifier = modifier
            .size(width = 48.dp, height = 48.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            ),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}