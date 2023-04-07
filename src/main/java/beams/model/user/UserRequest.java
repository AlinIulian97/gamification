package beams.model.user;

import beams.entity.Player;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    private Long id;
    private String userName;
    private String password;

}
