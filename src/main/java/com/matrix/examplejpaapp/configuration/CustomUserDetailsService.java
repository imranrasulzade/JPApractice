package com.matrix.examplejpaapp.configuration;

import com.matrix.examplejpaapp.entity.Authority;
import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepository userRepository;

    public CustomUserDetailsService(StudentRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student user = userRepository.findByUsername(username).orElseThrow();
        List<String> roles = new ArrayList<>();
        Set<Authority> authorities = user.getAuthorities();
        for (Authority authority : authorities) {
            roles.add(authority.getName());
        }
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
        return userDetails;
    }
}