package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.*

import java.util.List
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserController {
    private final UserService userService

    UserController(UserService userService) {
        this.userService = userService
    }

    @PostMapping
    User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.name, request.age, request.teamId)
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id)
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id)
    }

    static class CreateUserRequest {
        String name
        int age
        UUID teamId
    }
}