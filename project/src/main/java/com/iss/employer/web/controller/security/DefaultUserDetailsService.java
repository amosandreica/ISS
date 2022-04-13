package com.iss.employer.web.controller.security;

import com.iss.employer.core.model.Role;
import com.iss.employer.core.model.User;
import com.iss.employer.core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(this::mapToUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private UserDetails mapToUserDetails(User user) {
        Role role = user.getRole() == null ? Role.ROLE_EMPLOYEE : user.getRole();
        List<SimpleGrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(role.toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
