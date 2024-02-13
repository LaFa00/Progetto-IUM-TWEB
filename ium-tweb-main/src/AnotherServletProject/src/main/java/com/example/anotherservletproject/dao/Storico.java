package com.example.anotherservletproject.dao;

public class Storico extends Prenotazioni {
    public Storico(String utente, String ID_Utente, String nomeDocente, String cognomeDocente, String ID_Docente, String corso, String ID_Corso, String giorno, String orario, String available) {
        super(utente, ID_Utente, nomeDocente, cognomeDocente, ID_Docente, corso, ID_Corso, giorno, orario, available);
    }
}
