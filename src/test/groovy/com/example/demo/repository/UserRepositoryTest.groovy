package com.example.demo.repository

import com.example.demo.model.User
import com.example.demo.model.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class UserRepositoryTest extends Specification {
    @Autowired
    UserRepository userRepository
    @Autowired
    TeamRepository teamRepository

    def "test save and find user"() {
        given:
        def team = new Team(name: "Team A")
        teamRepository.save(team)
        def user = new User(name: "John Doe", age: 30, team: team)

        when:
        userRepository.save(user)
        def foundUser = userRepository.findById(user.id)

        then:
        foundUser.isPresent()
        foundUser.get().name == "John Doe"
    }
}