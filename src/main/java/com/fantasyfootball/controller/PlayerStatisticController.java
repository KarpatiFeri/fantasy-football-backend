package com.fantasyfootball.controller;

import com.fantasyfootball.model.player.PlayerStatistic;
import com.fantasyfootball.service.PlayerStatisticService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fantasy-football")
public class PlayerStatisticController {

    private final PlayerStatisticService playerStatisticService;

    @Autowired
    public PlayerStatisticController(PlayerStatisticService playerStatisticService) {
        this.playerStatisticService = playerStatisticService;
    }

    @GetMapping("/player-statistics")
    public List<PlayerStatistic> getAllPlayersStatistics() {
        return playerStatisticService.getPlayersStatistics();
    }
}
