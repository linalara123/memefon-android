package com.demoapp.memefon.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("photo") val photo: String,
    @SerialName("username") val username: String?
)