package com.iss.employer.web.controller.admin;

import com.iss.employer.core.model.TaskStatus;
import com.iss.employer.facade.TaskFacade;
import com.iss.employer.facade.UserFacade;
import com.iss.employer.facade.dto.Status;
import com.iss.employer.facade.dto.TaskDto;
import com.iss.employer.facade.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/tasks")
public class TasksController {
    private final TaskFacade taskFacade;
    private final UserFacade userFacade;

    @GetMapping("/")
    public String getTask(Model model) {
        List<TaskDto> tasks = taskFacade.findAll();
        model.addAttribute("tasks", tasks);
        return "admin/tasks";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String getForm(@PathVariable("id")int id, Model model) {
        Optional<UserDto> optionalUser = userFacade.findById(id);
        if(optionalUser.isEmpty()) {
            return "404";
        }
        TaskDto task = new TaskDto();
        UserDto assignee = optionalUser.get();
        task.setAssignee(assignee);
        model.addAttribute("task", task);
        model.addAttribute("selected", assignee.getId());
        model.addAttribute("users", userFacade.findAllEmployees());
        return "admin/addTask";
    }

    @GetMapping("/add")
    public String submit(@ModelAttribute("task") TaskDto task) {
        taskFacade.save(task);
        return "redirect:/admin/tasks/";
    }

}
