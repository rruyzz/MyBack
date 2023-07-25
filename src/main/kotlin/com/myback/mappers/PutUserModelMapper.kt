package com.myback.mappers

import com.myback.controller.request.PutUserRequest
import com.myback.model.user.UserModel

class PutUserModelMapper {
    operator fun invoke(userRequest: PutUserRequest, id: Int) : UserModel {
        return UserModel(
            userId = id,
            username = userRequest.username,
            profilePictureUrl = userRequest.profilePictureUrl,
        )
    }
}