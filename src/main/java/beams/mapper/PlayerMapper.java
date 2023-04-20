package beams.mapper;

import beams.entity.Player;
import beams.entity.User;
import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlayerMapper {

    Player map(PlayerRequest playerRequest);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "badgeId", source = "badge.id")
    PlayerResponse map(Player player);

    List<PlayerResponse> map(List<Player> list);
}
