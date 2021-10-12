package com.challenge.endpoints;

import com.challenge.service.impl.UserService;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.challenge.entity.User;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserServiceInterface {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable("id")  Long userId ) {
        return userService.findById(userId);
    }

    @Override
    @GetMapping(params = "accelerationName")
    public List<User> findByAccelerationName(@RequestParam String accelerationName){
        return userService.findByAccelerationName(accelerationName);
    }

    @Override
    @GetMapping(params = "companyId")
    public List<User> findByCompanyId(@RequestParam Long companyId) {
        return userService.findByCompanyId(companyId);
    }
}
