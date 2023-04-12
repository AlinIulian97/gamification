package beams.mapper;

import beams.entity.Badge;
import beams.model.badges.BadgeRequest;
import beams.model.badges.BadgeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BadgeMapper {

    Badge map(BadgeRequest badgeRequest);
    BadgeResponse map(Badge badge);

    List<BadgeResponse> map(List<Badge> badges);

}
