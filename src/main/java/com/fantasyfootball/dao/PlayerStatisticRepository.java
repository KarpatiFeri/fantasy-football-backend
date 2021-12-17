package com.fantasyfootball.dao;

import com.fantasyfootball.model.player.PlayerStatistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerStatisticRepository extends JpaRepository<PlayerStatistic, Long> {
}
