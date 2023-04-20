package beams.model.tokens;

import beams.entity.enums.EnumDifficulty;
import lombok.Data;

@Data
public class TokensResponse {

    private Long id;
    private String name;
    private int tokensNumbers;
    private EnumDifficulty enumDifficulty;
}
