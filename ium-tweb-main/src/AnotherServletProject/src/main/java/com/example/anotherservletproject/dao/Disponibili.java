package com.example.anotherservletproject.dao;

import java.util.Objects;

public class Disponibili {
    private String nomeDocente;
    private String cognomeDocente;
    private String ID_Docente;
    private String Corso;
    private String ID_Corso;
    private String giorno;
    private String orario;
    private String available;

    public Disponibili(String nomeDocente, String cognomeDocente, String ID_Docente, String corso, String ID_Corso, String giorno, String orario, String available) {
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.ID_Docente = ID_Docente;
        Corso = corso;
        this.ID_Corso = ID_Corso;
        this.giorno = giorno;
        this.orario = orario;
        this.available = available;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public String getCognomeDocente() {
        return cognomeDocente;
    }

    public void setCognomeDocente(String cognomeDocente) {
        this.cognomeDocente = cognomeDocente;
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

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disponibili that = (Disponibili) o;
        return Objects.equals(nomeDocente, that.nomeDocente) && Objects.equals(cognomeDocente, that.cognomeDocente) && Objects.equals(ID_Docente, that.ID_Docente) && Objects.equals(Corso, that.Corso) && Objects.equals(ID_Corso, that.ID_Corso) && Objects.equals(giorno, that.giorno) && Objects.equals(orario, that.orario) && Objects.equals(available, that.available);
    }

    @Override
    public String toString() {
        return "Disponibili{" +
                "nomeDocente='" + nomeDocente + '\'' +
                ", cognomeDocente='" + cognomeDocente + '\'' +
                ", ID_Docente='" + ID_Docente + '\'' +
                ", Corso='" + Corso + '\'' +
                ", ID_Corso='" + ID_Corso + '\'' +
                ", giorno='" + giorno + '\'' +
                ", orario='" + orario + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
