package beams.model.player;

import beams.entity.enums.EnumGender;
import beams.entity.enums.EnumRank;
import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private EnumGender gender;
    private EnumRank playerRank;
    private int score;
    private Long badgeId;
    private Long userId;

}
