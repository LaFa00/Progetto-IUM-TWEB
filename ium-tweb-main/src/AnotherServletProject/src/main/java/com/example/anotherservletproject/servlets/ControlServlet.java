package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.DAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="controlServlet", value="/controlServlet")
public class ControlServlet extends HttpServlet {
    public void init() {
        DAO.registerDriver();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action is : " + action);
        ServletContext ctx = request.getServletContext();
        RequestDispatcher rd;
        if(action != null) {
            switch (action) {
                case "Request role":
                    rd = ctx.getNamedDispatcher("servletLogin");
                    rd.include(request,response);
                    //ServletGen.requestRole(request,response);
                    break;
                case "Request logout":
                    rd = ctx.getNamedDispatcher("servletLogout");
                    rd.include(request,response);
                    //ServletLogin.requestLogOut(request, response);
                    break;
                case "Request corsi":
                    rd = ctx.getNamedDispatcher("servletCorsi");
                    rd.include(request,response);
                    break;
                case "Insert Prenotazione":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Request disponibili":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Request prenotazioni":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Request AllPrenotazioniDisponibili":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Delete Prenotazione":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Request AllPrenotazioniGuest":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Request AllPrenotazioniAdmin":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Check giorni":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Check orari":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request,response);
                    break;
                case "Insert admin":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Delete admin":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Insert admin Docente":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Insert admin Corso":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Delete admin Docente":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Delete admin Corso":
                    rd = ctx.getNamedDispatcher("servletAdmin");
                    rd.include(request,response);
                    break;
                case "Give Storico":
                    rd = ctx.getNamedDispatcher("servletPrenotazioni");
                    rd.include(request, response);
                    break;
                default:
                    break;
            }
        }
    }
}
