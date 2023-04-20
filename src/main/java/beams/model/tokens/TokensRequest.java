package beams.model.tokens;

import beams.entity.enums.EnumDifficulty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TokensRequest {

    private Long id;
    private String name;
    private int tokensNumbers;
    private EnumDifficulty enumDifficulty;
}
