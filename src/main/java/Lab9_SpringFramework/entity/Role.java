package Lab9_SpringFramework.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    VISITOR,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
