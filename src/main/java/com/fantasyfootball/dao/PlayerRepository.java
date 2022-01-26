package com.fantasyfootball.dao;

import com.fantasyfootball.model.player.Player;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByTeamId(Long team_id);
}
