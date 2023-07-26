package com.myback.repository

import com.myback.model.user.UserModel
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserModel, Int> {

    fun findByNameContaining(name: String): List<UserModel>
}