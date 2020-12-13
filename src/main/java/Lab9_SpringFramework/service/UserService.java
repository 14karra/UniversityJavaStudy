package Lab9_SpringFramework.service;


import Lab9_SpringFramework.entity.Role;
import Lab9_SpringFramework.entity.User;
import Lab9_SpringFramework.exceptions.AttemptToOverrideUserException;
import Lab9_SpringFramework.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User newUser) {
        newUser.setRole(Role.VISITOR);
        logger.info("Saving a new user. The new user: {}", newUser.toString());
        User user = userRepository.findById(newUser.getUsername()).orElse(null);
        if (user != null) {
            throw new AttemptToOverrideUserException(newUser.getUsername());
        }
        return userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
