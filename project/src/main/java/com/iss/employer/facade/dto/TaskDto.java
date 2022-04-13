package com.iss.employer.facade.dto;

import com.iss.employer.core.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private UserDto assignee;
}
