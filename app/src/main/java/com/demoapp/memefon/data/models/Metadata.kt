package com.demoapp.memefon.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Metadata(
    @SerialName("page")
    val page: Int,
    @SerialName("total")
    val total: Int
)