package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.Corso;
import com.example.anotherservletproject.dao.DAO;
import com.example.anotherservletproject.dao.Docente;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="servletDocenti", value="/servletDocenti")
public class ServletDocenti extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession adminSession = req.getSession();
        Gson docJS = new Gson();
        String finale = "";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String ruolo = (String) adminSession.getAttribute("role");
        String result = "";
        System.out.println("Ruolo : "+ruolo);
        if(adminSession.isNew() || !ruolo.equals("cliente")){
            //invalido la sessione
            out.print("Sessione invalidata!");
            adminSession.invalidate();
        }else{
            try{
                ArrayList<Docente> docs = DAO.getDocenti();
                System.out.println(docJS.toJson(docs));
                finale = docJS.toJson(docs);
                out.print(finale);
                result = "done";
            }catch(Exception e){
                System.out.println("Errore dopo JSON Corsi! "+e.getMessage());
                result = "failed";
            }
            System.out.println("Result is : "+result);

        }
    }
}
