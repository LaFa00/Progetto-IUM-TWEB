package com.example.anotherservletproject.servlets;

import com.example.anotherservletproject.dao.Corso;
import com.example.anotherservletproject.dao.DAO;
import com.example.anotherservletproject.dao.Insegnamento;
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

@WebServlet(name="servletInsegnamento", value="/servletInsegnamento")
public class ServletInsegnamento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession adminSession = req.getSession();
        Gson insJS = new Gson();
        String finale = "";
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String ruolo = (String) adminSession.getAttribute("role");
        String result = "";
        if(adminSession.isNew() || !ruolo.equals("cliente")){
            //invalido la sessione
            out.print("Sessione invalidata!");
            adminSession.invalidate();
        }else{
            try{
                ArrayList<Insegnamento> insegnamenti = DAO.getInsegnamento();
                System.out.println(insJS.toJson(insegnamenti));
                finale = insJS.toJson(insegnamenti);
                out.print(finale);
                result = "done";
            }catch(Exception e){
                System.out.println("Errore dopo JSON Insegnamenti! "+e.getMessage());
                result = "failed";
            }
            System.out.println("Result is : "+result);

        }
    }
}
