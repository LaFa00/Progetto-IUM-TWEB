package com.example.anotherservletproject.dao;
import java.util.Objects;

public class Docente {
    private String nome;
    private String cognome;
    private String ID_Docente;

    public Docente(String nome, String cognome, String ID_Docente) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID_Docente = ID_Docente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getID_Docente() {
        return ID_Docente;
    }

    public void setID_Docente(String ID_Docente) {
        this.ID_Docente = ID_Docente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(nome, docente.nome) && Objects.equals(cognome, docente.cognome) && Objects.equals(ID_Docente, docente.ID_Docente);
    }

    @Override
    public String toString() {
        return "Docente : " + nome + " " + cognome + " ";
    }
}
