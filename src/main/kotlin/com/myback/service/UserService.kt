package com.myback.service

import com.myback.controller.request.PostUserRequest
import com.myback.model.user.UserModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class UserService {

    val userList: MutableList<UserModel> = mutableListOf()

    fun getAll(name: String?): List<UserModel> {
        name?.let {
            return userList.filter { it.username.contains(name, true) }
        }
        println("userModel")
        return userList
    }

    fun create(userModel: UserModel) {
        println(userModel)
        val id = userList.lastOrNull()?.let {
            (it.userId ?: 0) + 1
        } ?: 0
        userList.add(UserModel(id, userModel.username, userModel.profilePictureUrl))
    }
    fun getUser(id: Int): UserModel {
        println(id)
        return userList.filter {
            it.userId == id
        }.first()
    }

    fun update(id: Int, userModel: UserModel) {
        userList.filter {
            it.userId == id
        }.first().let {
            it.username = userModel.username
            it.profilePictureUrl = userModel.profilePictureUrl
        }
    }
    fun delete(@PathVariable id: Int) {
        userList.removeIf {
            it.userId == id
        }
    }
}