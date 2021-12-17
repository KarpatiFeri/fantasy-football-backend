package com.fantasyfootball.service;

import com.fantasyfootball.dao.PlayerStatisticRepository;
import com.fantasyfootball.model.player.PlayerStatistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatisticService {

    private final PlayerStatisticRepository playerStatisticRepository;

    @Autowired
    public PlayerStatisticService(PlayerStatisticRepository playerStatisticRepository) {
        this.playerStatisticRepository = playerStatisticRepository;
    }

    public List<PlayerStatistic> getPlayersStatistics() {
        return playerStatisticRepository.findAll();
    }
}
