package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null || httpSession.getAttribute("user") == null) {
            resp.sendRedirect("/login.jsp");
        } else {
            resp.sendRedirect("/user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String admin = "admin";
        String user = "user";
        String password = req.getParameter("password");
        if (!password.isEmpty() && (admin.equals(req.getParameter("login")) || user.equals(req.getParameter("login")))) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user", admin);
            resp.sendRedirect("/user/hello.jsp");
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }
}
