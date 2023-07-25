package com.myback.mappers

import com.myback.controller.request.PostUserRequest
import com.myback.model.user.UserModel

class PostUserModelMapper {
    operator fun invoke(userRequest: PostUserRequest): UserModel {
        return UserModel(
            userId = null,
            username = userRequest.username,
            profilePictureUrl = userRequest.profilePictureUrl,
        )
    }
}