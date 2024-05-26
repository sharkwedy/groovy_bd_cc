package com.example.demo.repository

import com.example.demo.model.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class TeamRepositoryTest extends Specification {
    @Autowired
    TeamRepository teamRepository

    def "test save and find team"() {
        given:
        def team = new Team(name: "Team A")

        when:
        teamRepository.save(team)
        def foundTeam = teamRepository.findById(team.id)

        then:
        foundTeam.isPresent()
        foundTeam.get().name == "Team A"
    }
}