package com.example.anotherservletproject.dao;

public class Insegnamento {

   String NomeDocente;
   String CognomeDocente;
   String ID_Docente;
   String Corso;
   String ID_Corso;

    public Insegnamento(String nomeDocente, String cognomeDocente, String ID_Docente, String corso, String ID_Corso) {
        NomeDocente = nomeDocente;
        CognomeDocente = cognomeDocente;
        this.ID_Docente = ID_Docente;
        Corso = corso;
        this.ID_Corso = ID_Corso;
    }

    public String getNomeDocente() {
        return NomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        NomeDocente = nomeDocente;
    }

    public String getCognomeDocente() {
        return CognomeDocente;
    }

    public void setCognomeDocente(String cognomeDocente) {
        CognomeDocente = cognomeDocente;
    }

    public String getID_Docente() {
        return ID_Docente;
    }

    public void setID_Docente(String ID_Docente) {
        this.ID_Docente = ID_Docente;
    }

    public String getCorso() {
        return Corso;
    }

    public void setCorso(String corso) {
        Corso = corso;
    }

    public String getID_Corso() {
        return ID_Corso;
    }

    public void setID_Corso(String ID_Corso) {
        this.ID_Corso = ID_Corso;
    }
}
