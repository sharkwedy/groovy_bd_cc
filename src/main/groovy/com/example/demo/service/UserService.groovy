package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.model.Team
import com.example.demo.repository.UserRepository
import com.example.demo.repository.TeamRepository

import java.util.List
import java.util.UUID

class UserService {
    private final UserRepository userRepository
    private final TeamRepository teamRepository

    UserService(UserRepository userRepository, TeamRepository teamRepository) {
        this.userRepository = userRepository
        this.teamRepository = teamRepository
    }

    User createUser(String name, int age, UUID teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new IllegalArgumentException("Team not found"))
        User user = new User(name: name, age: age, team: team)
        return userRepository.save(user)
    }

    List<User> getAllUsers() {
        return userRepository.findAll()
    }

    User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"))
    }

    void deleteUser(UUID id) {
        userRepository.deleteById(id)
    }
}