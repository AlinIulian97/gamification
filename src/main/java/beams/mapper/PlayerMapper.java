package beams.mapper;

import beams.entity.Player;
import beams.entity.User;
import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;


public interface PlayerMapper {

    Player map(PlayerRequest playerRequest);

    PlayerResponse map(Player player);
}
