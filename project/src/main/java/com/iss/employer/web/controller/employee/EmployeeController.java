package com.iss.employer.web.controller.employee;

import com.iss.employer.facade.TaskFacade;
import com.iss.employer.facade.UserFacade;
import com.iss.employer.facade.dto.TaskDto;
import com.iss.employer.facade.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final UserFacade userFacade;
    private final TaskFacade taskFacade;

    @GetMapping
    public String getAccount(Model model) {
        Optional<UserDto> user = null;
        user = userFacade.getLoggedUser();
        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            return "employee/employeePage";
        } else {
            return "404";
        }
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        Optional<UserDto> user = null;
        user = userFacade.getLoggedUser();
        if(user.isPresent()) {
            model.addAttribute("tasks", taskFacade.findAllForEmployee(user.get()));
            return "employee/tasks";
        } else {
            return "404";
        }
    }

    @PostMapping("/tasks/update/{id}")
    public String updateTask(@PathVariable Integer id, Model model) {
        final Optional<TaskDto> taskDto = taskFacade.findById(id);
        if (taskDto.isEmpty()) {
            return "redirect:/employee/tasks/";
        }
        taskFacade.update(taskDto.get());
        return "redirect:/employee/tasks/";
    }
}
