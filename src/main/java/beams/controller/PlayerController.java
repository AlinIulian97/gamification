package beams.controller;

import beams.model.badges.BadgeResponse;
import beams.model.badges.BadgeUpdateNameResponse;
import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.player.UpdatePlayerName;
import beams.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/createPlayer")
    public PlayerResponse createPlayer(@RequestBody PlayerRequest playerRequest){
        return playerService.createPlayer(playerRequest);
    }

    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @PatchMapping("/update/{id}")
    public void updateName(@PathVariable Long id ,@RequestBody UpdatePlayerName name){
        playerService.updatePlayerName(id, name);
    }

    @GetMapping("/players")
    private List<PlayerResponse> players() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    private PlayerResponse getPlayer(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

}
