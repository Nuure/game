package com.game.service;

import com.game.controller.PlayerOrder;
import com.game.entity.Player;
import com.game.entity.Profession;
import com.game.entity.Race;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayersList();

    Integer getPlayersCount(String name, String title, Race race, Profession profession,
                            Long after, Long before, Boolean banned, Integer minExperience,
                            Integer maxExperience, Integer minLevel, Integer maxLevel);

    Player createPlayer(Player player);

    Player getPlayer(Long id);

    Boolean isValidPlayer(Player player);

    Player update(Player player, Long id);

    void delete(Long id);

    List<Player> sort(List<Player> players, PlayerOrder order);

    List<Player> getPage(List<Player> players, Integer pageNumber, Integer pageSize);

    List<Player> filteredPlayers(String name, String title, Race race, Profession profession,
                                 Long after, Long before, Boolean banned, Integer minExperience,
                                 Integer maxExperience, Integer minLevel, Integer maxLevel);


}
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    public @ResponseBody Iterable<Player> getAllPlayers() {
//        return playerRepository.findAll();
//    }
//
//    public @ResponseBody Long getPlayersCount() {
//        return playerRepository.count();
//    }
//
////    public @ResponseBody Iterable<Player> createPlayer() {
////        return playerRepository.findAll();
////    }
//
//    public void deletePlayer(@PathVariable Long id) throws BadHttpRequest {
//        if (id == 0) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        if (!playerRepository.findById(id).isPresent()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        try {
//            playerRepository.deleteById(id);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//    }
//}
