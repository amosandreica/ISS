package com.iss.employer.core.service.impl;

import com.iss.employer.core.model.Role;
import com.iss.employer.core.model.User;
import com.iss.employer.core.repository.UserRepository;
import com.iss.employer.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllEmployees() {
        List<User> users = userRepository.findAll();
        return users.stream().filter(user -> user.getRole().equals(Role.ROLE_EMPLOYEE)).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean save(User entity) {
        entity.setRole(Role.ROLE_EMPLOYEE);
        return userRepository.save(entity);
    }

    @Override
    public boolean delete(User entity) {
        return userRepository.delete(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return userRepository.deleteById(id);
    }

    @Override
    public boolean update(User entity) {
        return userRepository.update(entity);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
