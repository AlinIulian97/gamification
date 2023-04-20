package beams.service;

import beams.entity.Player;
import beams.exception.BusinessException;
import beams.mapper.PlayerMapper;
import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.player.UpdatePlayerName;
import beams.model.user.UserRequest;
import beams.repository.BadgeRepository;
import beams.repository.PlayerRepository;
import beams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlayerService {
    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;
    private final BadgeRepository badgeRepository;
    private final UserRepository userRepository;

    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        Player createPlayer = playerMapper.map(playerRequest);
        createPlayer.setBadge(badgeRepository.findById(playerRequest.getBadgeId()).orElseThrow(
                () -> new BusinessException("Badge is not found")));
        createPlayer.setUser(userRepository.findById(playerRequest.getUserId()).orElseThrow(
                () -> new BusinessException("User is not found")));
        playerRepository.save(createPlayer);
        return playerMapper.map(createPlayer);
    }

    public void deletePlayer(Long id) {
        Player deletePlayer = playerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Player is not found"));
        playerRepository.delete(deletePlayer);
    }

    public PlayerResponse getPlayer(Long id) {
        return playerMapper.map(playerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Player is not found")));
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerMapper.map(playerRepository.findAll());
    }

    public void updatePlayerName(Long id , UpdatePlayerName name){
        Player playerUpdateName = playerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Player is not found"));
        playerUpdateName.setName(name.getName());
        playerRepository.save(playerUpdateName);
    }
}
