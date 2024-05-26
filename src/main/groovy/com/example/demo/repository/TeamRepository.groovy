package com.example.demo.repository

import com.example.demo.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TeamRepository extends JpaRepository<Team, UUID> {
}