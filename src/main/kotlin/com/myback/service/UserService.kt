package com.myback.service

import com.myback.model.user.UserModel
import com.myback.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import java.lang.Exception

@Service
class UserService(
    val userRepository: UserRepository
) {

    val userList: MutableList<UserModel> = mutableListOf()

    fun getAll(name: String?): List<UserModel> {
        name?.let {
            return userRepository.findByNameContaining(name)
        }
        println("userModel")
        return userRepository.findAll().toList()
    }

    fun create(userModel: UserModel) {
        userRepository.save(userModel)
    }
    fun getUser(id: Int): UserModel {
        return userRepository.findById(id).orElseThrow()
    }

    fun update(userModel: UserModel) {
        if(userRepository.existsById(userModel.id!!).not()) throw Exception()
        userRepository.save(userModel)
    }
    fun delete(@PathVariable id: Int) {
        if(userRepository.existsById(id).not()) throw Exception()
        userRepository.deleteById(id)
    }
}