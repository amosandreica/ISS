package com.iss.employer.facade.dto;

import com.iss.employer.core.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<Task> assignedTasks;
    private Status status;
}
