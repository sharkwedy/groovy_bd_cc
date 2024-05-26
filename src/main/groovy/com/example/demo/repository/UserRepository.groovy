package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository extends JpaRepository<User, UUID> {
}