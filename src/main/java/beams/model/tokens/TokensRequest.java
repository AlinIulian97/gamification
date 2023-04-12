package beams.model.tokens;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TokensRequest {

    private Long id;
    private String name;
}
