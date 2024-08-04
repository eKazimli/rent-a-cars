package org.example.rentacar.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User.UserBuilder builder = null;
        if (username.equals("user")) {
            builder = User.withUsername("user");
            builder.password(new BCryptPasswordEncoder().encode("password"));
            builder.roles("USER");
        } else if (username.equals("admin")) {
            builder = User.withUsername("admin");
            builder.password(new BCryptPasswordEncoder().encode("admin"));
            builder.roles("ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

}
