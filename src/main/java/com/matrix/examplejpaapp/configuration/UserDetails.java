package com.matrix.examplejpaapp.configuration;

import com.matrix.examplejpaapp.entity.Student;
import com.matrix.examplejpaapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetails implements UserDetailsService {
    private final StudentRepository studentRepository;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("authenticating username {}" , username);
        Student student = studentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return new org.springframework.security.core.userdetails.UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "OPERATOR";
                    }
                });
            }

            @Override
            public String getPassword() {
                return student.getPassword();
            }

            @Override
            public String getUsername() {
                return student.getUsername();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
