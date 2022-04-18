package com.iss.employer.facade.impl;

import com.iss.employer.core.model.Task;
import com.iss.employer.core.model.User;
import com.iss.employer.core.service.TaskService;
import com.iss.employer.facade.TaskFacade;
import com.iss.employer.facade.converter.TaskConverter;
import com.iss.employer.facade.converter.UserConverter;
import com.iss.employer.facade.dto.TaskDto;
import com.iss.employer.facade.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultTaskFacade implements TaskFacade {
    private final TaskService taskService;
    private final TaskConverter taskConverter;
    private final UserConverter userConverter;

    @Override
    public List<TaskDto> findAll() {
        List<Task> tasks = taskService.findAll();
        return tasks.stream().map(taskConverter::convertTaskToTaskDto).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> findAllForEmployee(UserDto userDto) {
        User user = userConverter.convertUserDtoToUser(userDto);
        List<Task> tasks = taskService.findAllForEmployee(user);
        return tasks.stream().map(taskConverter::convertTaskToTaskDto).collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDto> findById(int id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            return Optional.ofNullable(taskConverter.convertTaskToTaskDto(task.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean save(TaskDto entity) {

        return taskService.save(taskConverter.convertTaskDtoToTask(entity));
    }

    @Override
    public boolean delete(TaskDto entity) {
        return taskService.delete(taskConverter.convertTaskDtoToTask(entity));
    }

    @Override
    public boolean deleteById(int id) {
        return taskService.deleteById(id);
    }

    @Override
    public boolean update(TaskDto entity) {
        return taskService.update(taskConverter.convertTaskDtoToTask(entity));
    }
}
