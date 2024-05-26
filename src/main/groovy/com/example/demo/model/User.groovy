package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import java.util.UUID

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id
    String name
    int age
    @ManyToOne
    Team team
}