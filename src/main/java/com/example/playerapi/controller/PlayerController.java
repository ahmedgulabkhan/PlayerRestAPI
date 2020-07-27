package com.example.playerapi.controller;

import java.util.List;

import com.example.playerapi.model.Player;
import com.example.playerapi.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // Get all players
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Get a single player
    @GetMapping("/player/{pId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("pId") String pId) {
        Player player = playerService.getPlayerDetailsById(pId);

        if(player == null) return new ResponseEntity<Player>(player, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    // Add a player
    @PostMapping("/player/add")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    // Update player details
    @PutMapping("/player/{pId}/update")
    public ResponseEntity<Player> updatePlayer(@PathVariable("pId") String pId, @RequestBody Player updatedPlayerDetails) {
        Player player = playerService.getPlayerDetailsById(pId);

        if(player == null) return new ResponseEntity<Player>(player, HttpStatus.NOT_FOUND);
        else {
            Player updatedPlayer = playerService.updatePlayerById(pId, updatedPlayerDetails);
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        }
    }

    // Delete a player
    @DeleteMapping("/player/{pId}/delete")
    public ResponseEntity<Player> deletePlayer(@PathVariable("pId") String pId) {
        Player player = playerService.getPlayerDetailsById(pId);
        if(player == null) return new ResponseEntity<Player>(player, HttpStatus.NOT_FOUND);
        else {
            playerService.deletePlayer(pId);
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        }
    }
}