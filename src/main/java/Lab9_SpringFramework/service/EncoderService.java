package Lab9_SpringFramework.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncoderService {

    private PasswordEncoder passwordEncoder;

    EncoderService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
