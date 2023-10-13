//package com.matrix.examplejpaapp.configuration;
//
//import com.matrix.examplejpaapp.entity.CustomSpringSecurityUser;
//import com.matrix.examplejpaapp.entity.Student;
//import com.matrix.examplejpaapp.model.StudentStatus;
//import com.matrix.examplejpaapp.repository.StudentRepository;
//import com.matrix.examplejpaapp.service.impl.JwtServiceee;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class UserDetails implements UserDetailsService {
//    private final StudentRepository studentRepository;
//    private final JwtServiceee jwtServiceee;
//        @Override
//    @Transactional
//    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("authenticating username {}", username);
//
//
//    return studentRepository.findByUsername(username)
//            .map(this::createSpringSecurityUser)
//            .orElseThrow(() -> new UsernameNotFoundException(username+ " not found"));
//    }
//
//    private CustomSpringSecurityUser createSpringSecurityUser(Student student){
//        checkUserProfileStatus(student);
//        List<GrantedAuthority> grantedAuthorities = student.getAuthorities().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//                .collect(Collectors.toList());
//
//        return new CustomSpringSecurityUser(student.getUsername(), student.getPassword(), grantedAuthorities);
//    }
//
//
//    private void checkUserProfileStatus(Student student) throws UsernameNotFoundException{
//        if(student.getStatus() != StudentStatus.ACTIVE){
//            throw new UsernameNotFoundException(student.getUsername() + " is not active");
//        }
//    }
//
//
//    // manual olan
//
////        Student student = studentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
//
////        return new org.springframework.security.core.userdetails.UserDetails() {
////            @Override
////            public Collection<? extends GrantedAuthority> getAuthorities() {
////                return List.of(new GrantedAuthority() {
////                    @Override
////                    public String getAuthority() {
////                        return "OPERATOR";
////                    }
////                });
////            }
////
////            @Override
////            public String getPassword() {
////                return student.getPassword();
////            }
////
////            @Override
////            public String getUsername() {
////                return student.getUsername();
////            }
////
////            @Override
////            public boolean isAccountNonExpired() {
////                return true;
////            }
////
////            @Override
////            public boolean isAccountNonLocked() {
////                return true;
////            }
////
////            @Override
////            public boolean isCredentialsNonExpired() {
////                return true;
////            }
////
////            @Override
////            public boolean isEnabled() {
////                return true;
////            }
////        };
// //   }
//}
