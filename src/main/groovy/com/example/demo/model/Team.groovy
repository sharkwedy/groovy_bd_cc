package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.util.UUID

@Entity
class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id
    String name
}