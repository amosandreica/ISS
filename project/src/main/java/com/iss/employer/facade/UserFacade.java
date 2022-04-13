package com.iss.employer.facade;

import com.iss.employer.core.model.User;
import com.iss.employer.facade.dto.UserDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

public interface UserFacade {
    List<UserDto> findAll();

    List<UserDto> findAllEmployees();

    Optional<UserDto> findById(int id);

    boolean save(UserDto entity);

    boolean delete(UserDto entity);

    boolean deleteById(int id);

    boolean update(UserDto entity);

    Optional<UserDto> getLoggedUser();
}
