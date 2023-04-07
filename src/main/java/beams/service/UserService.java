package beams.service;

import beams.entity.User;
import beams.exception.BusinessException;
import beams.mapper.UserMapper;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import beams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User createUser = userMapper.map(userRequest);
        if (isNewUser(userRequest)) {
            userRepository.save(createUser);
            return userMapper.map(createUser);
        } else throw new BusinessException("User exist or password exist ");

    }

    public List<UserResponse> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public Boolean isNewUser(UserRequest userRequest) {
        List<UserResponse> users = getAllUsers();
        if (getAllUsers().isEmpty()) {
            return true;
        }
        return users
                .stream()
                .noneMatch(userResponse
                        -> userResponse.getUserName().equals(userRequest.getUserName()) &&
                        userResponse.getPassword().equals(userRequest.getPassword()));
    }
}
