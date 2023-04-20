package beams.service;

import beams.entity.User;
import beams.exception.BusinessException;
import beams.mapper.UserMapper;
import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import beams.model.user.UserUpdatePassword;
import beams.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest userRequest) {
        User createUser = userMapper.map(userRequest);
        if (isNewUser(userRequest) && isValidPassword(userRequest)) {
            userRepository.save(createUser);
            return userMapper.map(createUser);
        } else throw new BusinessException("User exist or password exist ");

    }

    public List<UserResponse> getAllUsers() {
        return userMapper.map(userRepository.findAll());
    }

    public UserResponse getUser(Long id) {
        return userMapper.map(userRepository.findById(id).orElseThrow(
                () -> new BusinessException("User is not found")));
    }



    public Boolean isNewUser(UserRequest userRequest) {
        List<UserResponse> users = getAllUsers();
        if (getAllUsers().isEmpty()) {
            return true;
        }
        return users
                .stream()
                .noneMatch(userResponse
                        -> userResponse.getEmail().equals(userRequest.getEmail()) &&
                        userResponse.getPassword().equals(userRequest.getPassword()));
    }

    public Boolean isValidPassword(UserRequest userRequest) {
        String regex = "^[a-zA-Z][\\\\w]{7,29}$";
        String regex1 = "[a-zA-Z]";
        String userName = userRequest.getEmail();
        if (userName.length() < 8 || userName.length() > 30) {
            return false;
        } else if (userName.matches(regex)) {
            return false;
        }
        String check = userName.substring(0, 1).trim();
        return check.matches(regex1);
    }

    public void deleteUser(Long id) {
        User deleteUser = userRepository.findById(id).orElseThrow(
                () -> new BusinessException("User is not found"));
        userRepository.delete(deleteUser);
    }

    public void updatePassword(Long id, UserUpdatePassword updatePassword) {
        User updateUser = userRepository.findById(id).orElseThrow(
                () -> new BusinessException("User is not found"));
        updateUser.setPassword(updatePassword.getPassword());
    }

}
