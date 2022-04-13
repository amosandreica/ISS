package com.iss.employer.facade.converter;

import com.iss.employer.core.model.Role;
import com.iss.employer.core.model.User;
import com.iss.employer.facade.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    @Qualifier("passwordEncoder")
    private final PasswordEncoder passwordEncoder;

    public User convertUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAssignedTasks(userDto.getAssignedTasks());
        if(StringUtils.isNotEmpty(userDto.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        user.setEmail(userDto.getEmail());
        user.setRole(Role.ROLE_EMPLOYEE);

        return user;
    }

    public UserDto convertUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAssignedTasks(user.getAssignedTasks());

        return userDto;
    }
}
