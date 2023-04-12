package beams.service;

import beams.entity.Badge;
import beams.exception.BusinessException;
import beams.mapper.BadgeMapper;
import beams.model.badges.BadgeRequest;
import beams.model.badges.BadgeResponse;
import beams.model.badges.BadgeUpdateNameResponse;
import beams.repository.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BadgeService {
    private final BadgeRepository badgesRepository;
    private final BadgeMapper badgeMapper;

    public BadgeResponse createBadges(BadgeRequest badgesRequest) {
        Badge createBadge = badgeMapper.map(badgesRequest);
        badgesRepository.save(createBadge);
        return badgeMapper.map(createBadge);
    }

    public List<BadgeResponse> getAllBadges() {
        return badgeMapper.map(badgesRepository.findAll());
    }

    public BadgeResponse getBadge(Long id) {
        return badgeMapper.map(badgesRepository.findById(id).orElseThrow(
                () -> new BusinessException("Badger is not found")));
    }


    public void deleteBadge(Long id) {
        Badge deleteBadge = badgesRepository.findById(id).orElseThrow(
                () -> new BusinessException("Badge is not found"));
        badgesRepository.delete(deleteBadge);
    }

    public void updatePassword(Long id, BadgeUpdateNameResponse badgeUpdateNameResponse) {
        Badge updateBadgerName = badgesRepository.findById(id).orElseThrow(
                () -> new BusinessException("Badge is not found"));
        updateBadgerName.setName(badgeUpdateNameResponse.getName());
    }
}
