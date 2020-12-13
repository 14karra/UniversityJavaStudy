package Lab9_SpringFramework.controller;

import Lab9_SpringFramework.entity.User;
import Lab9_SpringFramework.service.EncoderService;
import Lab9_SpringFramework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.ROOT)
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final EncoderService encoderService;

    static final String ROOT = "/api/user";

    public UserController(UserService userService, EncoderService encoderService) {
        this.userService = userService;
        this.encoderService = encoderService;
    }

    @PostMapping(value = "/registration")
    public User saveUser(@RequestBody User newUser) {
        logger.info("Request to save a new user is received. New user: {}", newUser);
        newUser.setPassword(encoderService.encode(newUser.getPassword()));
        return userService.saveUser(newUser);
    }
}
