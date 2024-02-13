package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

@WebServlet(name="servletLogin",value="/servletLogin")
public class ServletLogin extends HttpServlet {

    public  void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("utente");
        System.out.println("user: "+user);
        String password = request.getParameter("password");
        System.out.println("password: "+password);
        String role = "";
        HttpSession userSession = request.getSession();
        if(!user.isEmpty() && !password.isEmpty()) {
            role = DAO.getUtente(user, password).get(0).getRuolo();
            userSession.setAttribute("user", user);
            userSession.setAttribute("password", password);
        }
        if(user.isEmpty() && password.isEmpty()){
            role = "guest";
        }
        userSession.setAttribute("role", role);
        out.print(role);
        out.flush();
    }

    /*public static void requestLogOut(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("utente");
        System.out.println(user);
        String password = request.getParameter("password");
        System.out.println(password);
        String role = DAO.getUtente(user, password).get(0).getRuolo();
        System.out.println(role);
        HttpSession userSession = request.getSession();
        userSession.invalidate();
    }*/
}
