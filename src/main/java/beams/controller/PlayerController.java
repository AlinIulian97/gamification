package beams.controller;

import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/createPlayer")
    public PlayerResponse createPlayer(@RequestBody PlayerRequest playerRequest){
        return playerService.createPlayer(playerRequest);
    }

}
