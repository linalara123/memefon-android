package com.demoapp.memefon.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemefonResponse(
    @SerialName("data") val data: List<Post>,
    @SerialName("metadata") val metadata: Metadata,
    @SerialName("status") val status: String
)

