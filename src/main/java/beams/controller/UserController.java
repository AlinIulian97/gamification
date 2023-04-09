package beams.controller;

import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
import beams.model.user.UserUpdatePassword;
import beams.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/createUser")
    private UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PatchMapping("/update/{id}")
    public void updatePassword(@PathVariable Long id ,@RequestBody UserUpdatePassword updatePassword){
        userService.updatePassword(id, updatePassword);
    }

    @GetMapping("/users")
    private List<UserResponse> users() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    private UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

}
