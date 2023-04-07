package beams.model.user;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String userName;
    private String password;
}
