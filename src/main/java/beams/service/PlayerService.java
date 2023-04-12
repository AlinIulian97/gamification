package beams.service;

import beams.entity.Player;
import beams.exception.BusinessException;
import beams.mapper.PlayerMapper;
import beams.model.player.PlayerRequest;
import beams.model.player.PlayerResponse;
import beams.model.user.UserRequest;
import beams.repository.BadgeRepository;
import beams.repository.PlayerRepository;
import beams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
