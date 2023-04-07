package beams.controller;

import beams.model.user.UserRequest;
import beams.model.user.UserResponse;
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
    private UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/users")
    private List<UserResponse> users(){
        return userService.getAllUsers();
    }

}
