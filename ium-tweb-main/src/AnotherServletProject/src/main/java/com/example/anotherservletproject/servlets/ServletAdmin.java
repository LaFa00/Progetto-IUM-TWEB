package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="servletAdmin",value="/servletAdmin")
public class ServletAdmin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(action.equals("Insert admin")) {
            String nomeDocente = request.getParameter("nomeDocente");
            System.out.println("NOME DOCENTE: " + nomeDocente);
            String cognomeDocente = request.getParameter("cognomeDocente");
            System.out.println("COGNOME DOCENTE: " + cognomeDocente);
            String ID_Docente = request.getParameter("ID_Docente");
            System.out.println("ID_DOCENTE: " + ID_Docente);
            String Corso = request.getParameter("Corso");
            System.out.println("Corso: " + Corso);
            String ID_Corso = request.getParameter("ID_Corso");
            System.out.println("ID_Corso " + ID_Corso);
            if(!ID_Corso.isEmpty() && !Corso.isEmpty() && !ID_Docente.isEmpty() && !nomeDocente.isEmpty() && !cognomeDocente.isEmpty()){
                DAO.insertCattedra(nomeDocente, cognomeDocente,ID_Docente, Corso, ID_Corso);
                System.out.println("Ho eliminato anche dalla tabella 'insegnamento'!");
            }
        }else if(action.equals("Delete admin")){
            String nomeDocente = request.getParameter("nomeDocente");
            System.out.println("NOME DOCENTE: " + nomeDocente);
            String cognomeDocente = request.getParameter("cognomeDocente");
            System.out.println("COGNOME DOCENTE: " + cognomeDocente);
            String ID_Docente = request.getParameter("ID_Docente");
            System.out.println("ID_DOCENTE: " + ID_Docente);
            String Corso = request.getParameter("Corso");
            System.out.println("Corso: " + Corso);
            String ID_Corso = request.getParameter("ID_Corso");
            System.out.println("ID_Corso " + ID_Corso);
            //delete from table insegnamento
            if(!ID_Corso.isEmpty() && !ID_Docente.isEmpty()){
                DAO.deleteCattedra(ID_Docente, ID_Corso);
                System.out.println("Ho eliminato dalla tabella 'insegnamento'!");
            }
        }else if(action.equals("Insert admin Corso")){
            String Corso = request.getParameter("Corso");
            System.out.println("Corso: " + Corso);
            String ID_Corso = request.getParameter("ID_Corso");
            System.out.println("ID_Corso " + ID_Corso);
            if(!ID_Corso.isEmpty() && !Corso.isEmpty()){
                DAO.insertCorso(Corso, ID_Corso);
                System.out.println("Corso aggiunto!");
            }
        }else if(action.equals("Insert admin Docente")){
            String nomeDocente = request.getParameter("nomeDocente");
            System.out.println("NOME DOCENTE: " + nomeDocente);
            String cognomeDocente = request.getParameter("cognomeDocente");
            System.out.println("COGNOME DOCENTE: " + cognomeDocente);
            String ID_Docente = request.getParameter("ID_Docente");
            System.out.println("ID_DOCENTE: " + ID_Docente);
            if(!ID_Docente.isEmpty() && !nomeDocente.isEmpty() && !cognomeDocente.isEmpty()){
                DAO.insertDocente(nomeDocente, cognomeDocente, ID_Docente);
                System.out.println("Docente aggiunto!");
            }
        }
        else if(action.equals("Delete admin Corso")){
            String Corso = request.getParameter("Corso");
            System.out.println("Corso: " + Corso);
            String ID_Corso = request.getParameter("ID_Corso");
            System.out.println("ID_Corso " + ID_Corso);
            if(!ID_Corso.isEmpty() && !Corso.isEmpty()){
                DAO.deleteCorso(Corso);
                System.out.println("Corso Eliminato!");
            }
        }else if(action.equals("Delete admin Docente")){
            String nomeDocente = request.getParameter("nomeDocente");
            System.out.println("NOME DOCENTE: " + nomeDocente);
            String cognomeDocente = request.getParameter("cognomeDocente");
            System.out.println("COGNOME DOCENTE: " + cognomeDocente);
            String ID_Docente = request.getParameter("ID_Docente");
            System.out.println("ID_DOCENTE: " + ID_Docente);
            if(!ID_Docente.isEmpty() && !nomeDocente.isEmpty() && !cognomeDocente.isEmpty()){
                DAO.deleteDocente(ID_Docente);
                System.out.println("Docente eliminato!");
            }
        }
    }
}