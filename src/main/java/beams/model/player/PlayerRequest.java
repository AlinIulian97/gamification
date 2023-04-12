package beams.model.player;

import beams.entity.Badge;
import beams.entity.User;
import beams.entity.enums.EnumGender;
import beams.entity.enums.EnumRank;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerRequest {

    private Long id;
    private String name;
    private EnumGender gender;
    private EnumRank playerRank;
    private int score;
    private Long badgeId;
    private Long userId;
}
