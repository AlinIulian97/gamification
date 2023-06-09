package beams.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {

    private Long id;
    private String email;
    private String password;

}
