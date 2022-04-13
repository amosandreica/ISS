package com.iss.employer.core.service;

import com.iss.employer.core.model.Task;
import com.iss.employer.core.model.User;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();

    List<Task> findAllForEmployee(User employee);

    Optional<Task> findById(int id);

    boolean save(Task entity);

    boolean delete(Task entity);

    boolean deleteById(int id);

    boolean update(Task entity);
}
