package com.iss.employer.web.controller.security;

import com.iss.employer.core.model.Role;
import com.iss.employer.facade.UserFacade;
import com.iss.employer.utils.ActiveUserStore;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
public class DefaultAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler {

    private final UserFacade userFacade;
    private static final Map<String, String> ROLE_TARGET_URL_MAP = new HashMap<>();
    private SavedRequestAwareAuthenticationSuccessHandler savedRequest;
    private final ActiveUserStore activeUserStore;

    static {
        ROLE_TARGET_URL_MAP.put(Role.ROLE_EMPLOYEE.toString(), "/employee");
        ROLE_TARGET_URL_MAP.put(Role.ROLE_ADMIN.toString(), "/admin");
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Optional<GrantedAuthority> authority = getAuthority(authentication);
        if (authority.isPresent() && authority.get().getAuthority().equals(Role.ROLE_EMPLOYEE.toString())) {
            List<String> activeUsers = activeUserStore.getUsers();
            String authenticationName = authentication.getName();
            if(!activeUsers.contains(authenticationName)) {
                activeUsers.add(authenticationName);
            }
        }
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String defaultTargetUrl = super.determineTargetUrl(request, response, authentication);
        Optional<GrantedAuthority> authority = getAuthority(authentication);

        if (authority.isEmpty()) {
            return defaultTargetUrl;
        }

        return ROLE_TARGET_URL_MAP.getOrDefault(authority.get().getAuthority(), defaultTargetUrl);
    }

    private Optional<GrantedAuthority> getAuthority(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (authorities == null || authorities.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(authorities.iterator().next());
    }
}

