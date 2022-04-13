package com.iss.employer.core.service.impl;

import com.iss.employer.core.model.Task;
import com.iss.employer.core.model.User;
import com.iss.employer.core.repository.TaskRepository;
import com.iss.employer.core.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultTaskService implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllForEmployee(User employee) {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().filter(task -> task.getAssignee().equals(employee))
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public boolean save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public boolean delete(Task entity) {
        return taskRepository.delete(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return taskRepository.deleteById(id);
    }

    @Override
    public boolean update(Task entity) {
        return taskRepository.update(entity);
    }
}
