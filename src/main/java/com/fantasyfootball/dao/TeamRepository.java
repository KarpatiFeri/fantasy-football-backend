package com.fantasyfootball.dao;

import com.fantasyfootball.model.team.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
