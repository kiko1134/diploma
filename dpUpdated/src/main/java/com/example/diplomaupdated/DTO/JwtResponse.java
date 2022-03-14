package com.example.diplomaupdated.DTO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    @NotNull
    private String token;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String token, String username, String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.authorities = authorities;
    }
}
