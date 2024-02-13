package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="servletLogout", value="/servletLogout")
public class ServletLogOut extends HttpServlet {

    public  void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("utente");
        System.out.println(user);
        String password = request.getParameter("password");
        System.out.println(password);
        String role = "";
        if(!user.isEmpty() && !password.isEmpty()) {
            role = DAO.getUtente(user, password).get(0).getRuolo();
        } else {
            role = "guest";
        }
        System.out.println(role);
        HttpSession userSession = request.getSession();
        System.out.println("Invalido sessione utente : "+userSession.getId());
        userSession.invalidate();
        System.out.println("Sessione utente invalidata correttamente!");
    }
}
