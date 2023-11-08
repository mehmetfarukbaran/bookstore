package com.mehmetfaruk.bookstore.auth;

import com.mehmetfaruk.bookstore.user.model.User;
import com.mehmetfaruk.bookstore.user.repo.UserRepository;
import com.mehmetfaruk.bookstore.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationService implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        userService.createAdminIfNoUser(name,password);
        User user = userRepository.findByUsernameAndPassword(name, password);

        if (user == null) {
            throw new AuthenticationException("User not found") {
            };
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role));
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                name, password, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
