package com.pmg.mymusictaste.config.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.config.auth.dto.SessionMember;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private HttpSession httpSession;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        httpSession = request.getSession();
        SessionMember member = (SessionMember) httpSession.getAttribute("user");
        if (member != null) {
            httpSession.setAttribute("userName", member.getName());
            httpSession.setAttribute("userEmail", member.getEmail());
            httpSession.setAttribute("userImg", member.getPicture());
        }
        log.info("MEMBER========================= : " + member);
        log.info("LOGIN SUCCESS HANDLER 진입===========================================================");
        log.info("REQUEST================== : " + request);
        log.info("authentication================== : " + authentication + "");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>location.href='popup.html';</script>");
        out.flush();
    }

}