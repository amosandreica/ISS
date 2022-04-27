package com.iss.employer.facade.converter;

import com.iss.employer.core.model.Task;
import com.iss.employer.core.model.TaskStatus;
import com.iss.employer.facade.dto.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskConverter {
    private final UserConverter userConverter;

    public Task convertTaskDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setAssignee(userConverter.convertUserDtoToUser(taskDto.getAssignee()));

        return task;
    }

    public TaskDto convertTaskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setAssignee(userConverter.convertUserToUserDto(task.getAssignee()));

        return taskDto;
    }
}
