package com.iss.employer.web.controller.employee;

import com.iss.employer.core.service.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}