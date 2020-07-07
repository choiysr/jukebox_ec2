package com.pmg.mymusictaste.config.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.config.auth.dto.SessionMember;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private HttpSession httpSession;
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        log.info("LOGIN SUCCESS HANDLER");

        // httpSession = request.getSession();
        // redirectStratgy.sendRedirect(request, response, "popup.html");
        // SessionMember member = (SessionMember) httpSession.getAttribute("user");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // out.println("<script>var windowpop=window.open('about:blank','_self'); windowpop.close();</script>");
        // out.println("<script>window.open('', '_self', '');window.close();</script>");
        // out.println("<script>chrome.windows.getCurrent(true,(window)=>{chrome.windows.remove(window.id)})</script>");
        out.println("<script>chrome.windows.remove(-2)</script>");
        out.flush();
    }

}