package beams.mapper;

import beams.entity.User;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    User map(UserRequest userRequest);

    UserResponse map(User user);

    List<UserResponse> map(List<User> users);
}
