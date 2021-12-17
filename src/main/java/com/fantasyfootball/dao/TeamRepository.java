package com.fantasyfootball.dao;

import com.fantasyfootball.model.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
