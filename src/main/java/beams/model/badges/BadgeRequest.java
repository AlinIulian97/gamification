package beams.model.badges;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BadgeRequest {

    private Long id;
    private String name;
}
