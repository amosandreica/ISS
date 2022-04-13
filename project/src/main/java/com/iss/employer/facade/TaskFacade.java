package com.iss.employer.facade;

import com.iss.employer.facade.dto.TaskDto;
import com.iss.employer.facade.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface TaskFacade {
    List<TaskDto> findAll();

    List<TaskDto> findAllForEmployee(UserDto employee);

    Optional<TaskDto> findById(int id);

    boolean save(TaskDto entity);

    boolean delete(TaskDto entity);

    boolean deleteById(int id);

    boolean update(TaskDto entity);
}
