package com.demoapp.memefon.ui.componets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demoapp.memefon.data.text_util.getSocialPostDate
import com.demoapp.memefon.ui.theme.MemefonTheme

@Preview
@Composable
private fun previewUserCard() {
    MemefonTheme() {
        UserCardHeader(
            userPhoto = "https://memefon.s3.amazonaws.com/uploads/2021-08-16T03-41-24031Z-nmpxfqthkvngtt8qmax5.octet-stream",
            userName = "Hackerman",
            postDate = "2022-10-28T22:28:16.231Z",
            category = "Funny"
        )
    }
}


@Composable
fun UserCardHeader(
    userPhoto: String,
    userName: String,
    postDate: String,
    category: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = androidx.compose.ui.Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(60.dp)
    ) {
        CircularImage(
            imageUrl = userPhoto,
            modifier = Modifier.wrapContentHeight()
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                userName,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.wrapContentHeight()
            )
            Text(
                postDate.getSocialPostDate(),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.wrapContentHeight()
            )
            Text(
                modifier = Modifier.background(MaterialTheme.colorScheme.surfaceVariant),
                text = category,
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.primary),
                textAlign = TextAlign.End
            )
        }

    }
}