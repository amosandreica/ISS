package com.iss.employer.web.controller.admin;


import com.iss.employer.facade.UserFacade;
import com.iss.employer.facade.dto.Status;
import com.iss.employer.facade.dto.UserDto;
import com.iss.employer.utils.ActiveUserStore;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/accounts")
public class AccountsController {
    private final UserFacade userFacade;
    @Autowired
    ActiveUserStore activeUserStore;

    @GetMapping("/")
    public String getAccounts(Model model) {
        List<UserDto> users = userFacade.findAllEmployees();
        List<String> activeUsers = activeUserStore.getUsers();
        users.forEach(employee -> {
            if(activeUsers.contains(employee.getEmail())){
                employee.setStatus(Status.ONLINE);
            } else {
                employee.setStatus(Status.OFFLINE);
            }
        });
        model.addAttribute("users", users);
        return "admin/accounts";
    }

    @GetMapping("/{id}")
    public String getAccounts(@PathVariable("id")int id, Model model) {
        Optional<UserDto> user = null;
        user = userFacade.findById(id);
        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            return "admin/details";
        } else {
            return "404";
        }
    }

    @RequestMapping(value = "/add/", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "admin/addAccount";
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") UserDto user) {
        userFacade.save(user);
        return "redirect:/admin/accounts/";
    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable Integer id){
        userFacade.deleteById(id);
        return "redirect:/admin/accounts/";
    }

    @PostMapping("/update/{id}")
    public String updateAccount(@PathVariable Integer id, Model model){
        final Optional<UserDto> userDto = userFacade.findById(id);
        if (userDto.isEmpty()) {
            return "redirect:/admin/accounts/";
        }
        model.addAttribute("user", userDto.get());
        return "admin/updateAccount";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("user") UserDto userDto) {
        userFacade.update(userDto);
        return "redirect:/admin/accounts/";
    }

}
