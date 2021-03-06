package com.fantasyfootball.controller;

import java.util.List;

import com.fantasyfootball.model.player.Player;
import com.fantasyfootball.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fantasy-football")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayer() {
        return playerService.getPlayers();
    }

    @GetMapping("/players/{id}")
    public List<Player> getPlayersByTeamId(@PathVariable Long id) {
        return playerService.getPlayersByTeamId(id);
    }
}
