package com.iss.employer.core.service;

import com.iss.employer.core.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    List<User> findAllEmployees();

    Optional<User> findById(int id);

    boolean save(User entity);

    boolean delete(User entity);

    boolean deleteById(int id);

    boolean update(User entity);

    Optional<User> getByEmail(String email);
}
