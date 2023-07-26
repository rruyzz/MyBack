package com.myback.mappers

import com.myback.controller.request.PutUserRequest
import com.myback.model.user.UserModel

class PutUserModelMapper {
    operator fun invoke(userRequest: PutUserRequest, id: Int) : UserModel {
        return UserModel(
            id = id,
            name = userRequest.username,
            email = userRequest.profilePictureUrl,
        )
    }
}