package com.fantasyfootball.dao;

import com.fantasyfootball.model.player.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
