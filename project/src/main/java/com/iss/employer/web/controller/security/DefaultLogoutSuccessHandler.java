package com.iss.employer.web.controller.security;

import com.iss.employer.core.service.UserService;
import com.iss.employer.utils.ActiveUserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class DefaultLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Autowired
    private final ActiveUserStore activeUserStore;

    public DefaultLogoutSuccessHandler(ActiveUserStore activeUserStore) {
        setDefaultTargetUrl("/login");
        this.activeUserStore = activeUserStore;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        List<String> activeUsers = activeUserStore.getUsers();
        String authenticationName = authentication.getName();
        if(activeUsers.contains(authenticationName)) {
            activeUsers.remove(authenticationName);
        }
        super.onLogoutSuccess(request, response, authentication);
    }
}
