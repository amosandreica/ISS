package com.iss.employer.facade.impl;

import com.iss.employer.core.model.User;
import com.iss.employer.core.service.UserService;
import com.iss.employer.facade.UserFacade;
import com.iss.employer.facade.converter.UserConverter;
import com.iss.employer.facade.dto.Status;
import com.iss.employer.facade.dto.UserDto;
import com.iss.employer.utils.ActiveUserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultUserFacade implements UserFacade {
    private final UserService userService;
    private final UserConverter userConverter;

    @Override
    public List<UserDto> findAll() {
        List<User> users = userService.findAll();
        return users.stream().map(userConverter::convertUserToUserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findAllEmployees() {
        List<User> users = userService.findAllEmployees();
        List<UserDto> employees = users.stream().map(userConverter::convertUserToUserDto).collect(Collectors.toList());
        return employees;
    }

    @Override
    public Optional<UserDto> findById(int id) {
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            UserDto userDto = userConverter.convertUserToUserDto(user.get());
            return Optional.ofNullable(userDto);
        }
        return Optional.empty();
    }

    @Override
    public boolean save(UserDto entity) {
        User user = userConverter.convertUserDtoToUser(entity);
        return userService.save(user);
    }

    @Override
    public boolean delete(UserDto entity) {
        User user = userConverter.convertUserDtoToUser(entity);
        return userService.delete(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userService.deleteById(id);
    }

    @Override
    public boolean update(UserDto entity) {
        User user = userConverter.convertUserDtoToUser(entity);
        return userService.update(user);
    }

    @Override
    public Optional<UserDto> getLoggedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> userOptional = userService.getByEmail(email);
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        User user = userOptional.get();

        return Optional.ofNullable(userConverter.convertUserToUserDto(user));
    }
}
