package com.myback.controller

import com.myback.controller.request.PostUserRequest
import com.myback.controller.request.PutUserRequest
import com.myback.mappers.PostUserModelMapper
import com.myback.mappers.PutUserModelMapper
import com.myback.model.user.UserModel
import com.myback.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class MyBackController(
    val userService: UserService,

) {
    val postMapper: PostUserModelMapper = PostUserModelMapper()
    val putMapper: PutUserModelMapper= PutUserModelMapper()

    @GetMapping
    fun getAll(@RequestParam name: String?) : UserModel {
//        return userService.getAll(name)
        return UserModel(12345,"dsjfdl","çdskf")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody userModel: PostUserRequest) {
        userService.create(postMapper(userModel))
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): UserModel {
        return userService.getUser(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody putUser: PutUserRequest) {
        userService.update(id, putMapper(putUser, id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        userService.delete(id)
    }
}


