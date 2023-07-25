package com.myback.controller.request

data class PutUserRequest(
    val username: String,
    val profilePictureUrl: String,
)