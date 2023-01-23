package com.game.controller;

import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;
import com.game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/players")
    public ResponseEntity<Player> create(@RequestBody Player player) {
        if (!playerService.isValidPlayer(player)) {
            return new ResponseEntity<>(player, HttpStatus.BAD_REQUEST);
        }
        playerService.createPlayer(player);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping(value = "/players")
    public ResponseEntity<List<Player>> readAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "race", required = false) Race race,
            @RequestParam(value = "profession", required = false) Profession profession,
            @RequestParam(value = "after", required = false) Long after,
            @RequestParam(value = "before", required = false) Long before,
            @RequestParam(value = "banned", required = false) Boolean banned,
            @RequestParam(value = "minExperience", required = false) Integer minExperience,
            @RequestParam(value = "maxExperience", required = false) Integer maxExperience,
            @RequestParam(value = "minLevel", required = false) Integer minLevel,
            @RequestParam(value = "maxLevel", required = false) Integer maxLevel,
            @RequestParam(value = "order", required = false) PlayerOrder order,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ) {
        final List<Player> filteredPlayers = playerService.filteredPlayers(name, title, race, profession,
                after, before, banned, minExperience, maxExperience, minLevel, maxLevel);
        final List<Player> sortedPlayers = playerService.sort(filteredPlayers, order);
        final List<Player> playersOnPage = playerService.getPage(sortedPlayers, pageNumber, pageSize);
        return new ResponseEntity<>(playersOnPage, HttpStatus.OK);
    }

    @GetMapping(value = "/players/count")
    public ResponseEntity<Integer> getCountPlayers(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "race", required = false) Race race,
            @RequestParam(value = "profession", required = false) Profession profession,
            @RequestParam(value = "after", required = false) Long after,
            @RequestParam(value = "before", required = false) Long before,
            @RequestParam(value = "banned", required = false) Boolean banned,
            @RequestParam(value = "minExperience", required = false) Integer minExperience,
            @RequestParam(value = "maxExperience", required = false) Integer maxExperience,
            @RequestParam(value = "minLevel", required = false) Integer minLevel,
            @RequestParam(value = "maxLevel", required = false) Integer maxLevel
    ) {
        final Integer count = playerService.getPlayersCount(name, title, race, profession,
                after, before, banned, minExperience, maxExperience, minLevel, maxLevel);
        return count != null ?
                new ResponseEntity<>(count, HttpStatus.OK) :
                new ResponseEntity<>(count, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/players/{id}")
    public ResponseEntity<Player> read(@PathVariable(name = "id") Long id) {
        final Player player = playerService.getPlayer(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping(value = "/players/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerService.update(player, id);
    }

    @DeleteMapping(value = "/players/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        if (id == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        playerService.delete(id);
    }
}
//
//    PlayerService playerService = new PlayerService();
//
//    @GetMapping(path = "/players")
//    public @ResponseBody Iterable<Player> getAllPlayers(){
//        return playerService.getAllPlayers();
//    }
//
//    @GetMapping(path = "/players/count")
//    public @ResponseBody Long getPlayersCount(){
//        return playerService.getPlayersCount();
//    }
//
////    @PostMapping(path = "/players")
////    public @ResponseBody void createPlayer(){
////        return playerService.
////    }
//
//    @DeleteMapping(path = "/players/{id}")
//    public void deletePlayer(@PathVariable Long id) throws BadHttpRequest {
//        playerService.deletePlayer(id);
//    }
//}
