package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.*;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name="servletPrenotazioni", value="/servletPrenotazioni")
public class ServletPrenotazioni extends HttpServlet {
//ADADA
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (action.equals("Insert Prenotazione")) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String idUtente = DAO.getUtente(user, password).get(0).getID_Utente();
            String NomeDocente = request.getParameter("NomeDocente");
            String CognomeDocente = request.getParameter("CognomeDocente");
            String corso = request.getParameter("corso");
            String giorno = request.getParameter("giorno");
            String orario = request.getParameter("orario");
            String idCorso = DAO.getCorsi(corso).get(0).getID_Corso();
            String idDocente = DAO.getDocenti(NomeDocente, CognomeDocente).get(0).getID_Docente();
            System.out.println(DAO.insertPrenotazioni(user, idUtente, NomeDocente, CognomeDocente, idDocente, corso, idCorso, giorno, orario, "Effettuata"));
            out.print("Successo");
        } else if (action.equals("Request prenotazioni")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String ruolo = (String) adminSession.getAttribute("role");
            String result = "";
            if (adminSession.isNew() || ruolo.equals(" ")) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    String user = request.getParameter("utente");
                    String password = request.getParameter("password");
                    System.out.println("Utente Prenotazioni: " + user);
                    String id = DAO.getUtente(user, password).get(0).getID_Utente();
                    System.out.println("ID Prenotazioni: " + id);
                    ArrayList<Prenotazioni> prenotazioni = DAO.getPrenotazioni(user, id);
                    System.out.println("PRENOTAZIONI : " + prenotazioni.toString());
                    finale = insJS.toJson(prenotazioni);
                    System.out.println(finale.toString());
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println("Errore dopo JSON Insegnamenti! " + e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Request AllPrenotazioniDisponibili")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String ruolo = (String) adminSession.getAttribute("role");
            String result = "";
            if (adminSession.isNew() || ruolo.equals(" ")) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    String user = request.getParameter("utente");
                    String password = request.getParameter("password");
                    String id = DAO.getUtente(user, password).get(0).getID_Utente();
                    System.out.println("ID Prenotazioni: " + id);
                    ArrayList<Prenotazioni> mieprenotazioni = DAO.getPrenotazioni(user, id);
                    ArrayList<Disponibili> prenotazioni = null;
                    if(mieprenotazioni.size() > 0 || !mieprenotazioni.isEmpty()) {
                         prenotazioni = DAO.getPrenotazioniDisponibili(user);
                    }else{
                        prenotazioni = DAO.getDisponibili();
                    }
                    finale = insJS.toJson(prenotazioni);
                    System.out.println(finale.toString());
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Delete Prenotazione")) {
            String user = request.getParameter("user");
            System.out.println("UTENTE " + user);
            String password = request.getParameter("password");
            System.out.println("PASSWORD " + password);
            String ID_Utente = DAO.getUtente(user, password).get(0).getID_Utente();
            System.out.println("ID_Utente " + ID_Utente);
            String NomeDocente = request.getParameter("NomeDocente");
            String CognomeDocente = request.getParameter("CognomeDocente");
            String ID_Docente = DAO.getDocenti(NomeDocente, CognomeDocente).get(0).getID_Docente();
            System.out.println("ID_DOCENTE" + ID_Docente);
            String Corso = request.getParameter("corso");
            String ID_Corso = DAO.getCorsi(Corso).get(0).getID_Corso();
            System.out.println("ID_CORSO " + ID_Corso);
            String Giorno = request.getParameter("giorno");
            String Orario = request.getParameter("orario");
            DAO.deletePrenotazioni(user, ID_Utente, NomeDocente, CognomeDocente, ID_Docente, Corso, ID_Corso, Giorno, Orario);
        } else if (action.equals("Request AllPrenotazioniGuest")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String ruolo = (String) adminSession.getAttribute("role");
            System.out.println("Ruolo: " + ruolo);
            String result = "";
            if (adminSession.isNew() || !ruolo.equals("guest")) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    String user = request.getParameter("utente");
                    String password = request.getParameter("password");
                    System.out.println("User : " + user);
                    ArrayList<Disponibili> prenotazioni = DAO.getDisponibili();
                    System.out.println("Prenotazioni Array: " + prenotazioni.toString());
                    finale = insJS.toJson(prenotazioni);
                    System.out.println(finale.toString());
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Request disponibili")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String utente = (String) adminSession.getAttribute("user");
            String password = (String) adminSession.getAttribute("password");
            String ruolo = (String) adminSession.getAttribute("role");
            String result = "";
            if (adminSession.isNew() || ruolo.equals(" ")) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    ArrayList<Disponibili> disponibili = DAO.getDisponibili();
                    System.out.println(insJS.toJson(disponibili));
                    finale = insJS.toJson(disponibili);
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println("Errore dopo JSON Insegnamenti! " + e.getMessage());
                    result = "failed";
                }
                System.out.println("Result is : " + result);

            }
        } else if (action.equals("Check giorni")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            String result = "";
            response.setContentType("application/json");
            String user = request.getParameter("utente");
            System.out.println(user);
            String password = request.getParameter("password");
            System.out.println(password);
            String corso = request.getParameter("corso");
            System.out.println("Corso da cercare : " + corso);
            if (adminSession.isNew()) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    ArrayList<String> days = DAO.getGiorni(corso);
                    System.out.println(days);
                    finale = insJS.toJson(days);
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Check orari")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            String result = "";
            response.setContentType("application/json");
            String user = request.getParameter("utente");
            System.out.println(user);
            String password = request.getParameter("password");
            System.out.println(password);
            String corso = request.getParameter("corso");
            System.out.println("Corso da cercare : " + corso);
            String giorno = request.getParameter("giorno");
            System.out.println("giorno sel : " + giorno);
            if (adminSession.isNew()) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    ArrayList<String> hours = DAO.getOrari(corso, giorno);
                    System.out.println(hours);
                    finale = insJS.toJson(hours);
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Request AllPrenotazioniAdmin")) {
            System.out.println("REQUEST PRENOTAZIONI ADMIN!");
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String ruolo = (String) adminSession.getAttribute("role");
            System.out.println("Ruolo: " + ruolo);
            String result = "";
            if (adminSession.isNew() || !ruolo.equals("amministratore")) {
                //invalido la sessione
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else {
                try {
                    String user = request.getParameter("utente");
                    String password = request.getParameter("password");
                    System.out.println("USER : " + user);
                    ArrayList<Disponibili> prenotazioni = DAO.getPrenotazioniDisponibili(user);
                    System.out.println("Prenotazioni Array: " + prenotazioni.toString());
                    finale = insJS.toJson(prenotazioni);
                    System.out.println(finale.toString());
                    out.print(finale);
                    result = "done";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        } else if (action.equals("Give Storico")) {
            HttpSession adminSession = request.getSession();
            Gson insJS = new Gson();
            String finale = "";
            response.setContentType("application/json");
            String ruolo = (String) adminSession.getAttribute("role");
            System.out.println("Ruolo: " + ruolo);
            String result = "";
            if (adminSession.isNew()) {
                out.print("Sessione invalidata!");
                adminSession.invalidate();
            } else if (ruolo.equals("amministratore")) {
                String user = request.getParameter("utente");
                String password = request.getParameter("password");
                System.out.println("USER : " + user);
                ArrayList<Storico> storico = DAO.getStorico(user);
                System.out.println("Stampa storico : " + storico.toString());
                finale = insJS.toJson(storico);
                out.print(finale);
                result = "admin has done!";
            } else {
                try {
                    String user = request.getParameter("utente");
                    String password = request.getParameter("password");
                    System.out.println("USER : " + user);
                    ArrayList<Storico> storicoUtente = DAO.getStorico(user);
                    System.out.println("StoricoArray: " + storicoUtente.toString());
                    finale = insJS.toJson(storicoUtente);
                    System.out.println(finale.toString());
                    out.print(finale);
                    result = "utente has done!";
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    result = "failed";
                }
            }
        }
    }

}

