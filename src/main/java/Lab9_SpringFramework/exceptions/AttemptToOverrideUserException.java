package Lab9_SpringFramework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AttemptToOverrideUserException extends RuntimeException {

    public AttemptToOverrideUserException(String username) {
        super("There was an attempt to override some existing credentials. Provided username = " + username);
    }
}
