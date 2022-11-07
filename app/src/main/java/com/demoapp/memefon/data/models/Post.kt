package com.demoapp.memefon.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    @SerialName("category")
    val category: Category,
    @SerialName("commentsCount")
    val commentsCount: Int,
    @SerialName("createdAt")
    val createdAt: String,
    @SerialName("_id")
    val id: String,
    @SerialName("imageUrl")
    val imageUrl: String? = null,
    @SerialName("likedByCurrentUser")
    val likedByCurrentUser: Int,
    @SerialName("likesCount")
    val likesCount: Int,
    @SerialName("reportedByCurrentUser")
    val reportedByCurrentUser: Int,
    @SerialName("title")
    val title: String,
    @SerialName("user")
    val user: User,
    @SerialName("videoUrl")
    val videoUrl: String? = null
)