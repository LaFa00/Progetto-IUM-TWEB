package com.example.anotherservletproject.dao;

import java.util.Objects;

public class Utente {
    private String account;
    private String password;
    private String ruolo;
    private String ID_Utente;

    public Utente(String account, String password, String ruolo, String ID_Utente) {
        this.account = account;
        this.password = password;
        this.ruolo = ruolo;
        this.ID_Utente = ID_Utente;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getID_Utente() {
        return ID_Utente;
    }

    public void setID_Utente(String ID_Utente) {
        this.ID_Utente = ID_Utente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return Objects.equals(account, utente.account) && Objects.equals(password, utente.password) && Objects.equals(ruolo, utente.ruolo) && Objects.equals(ID_Utente, utente.ID_Utente);
    }

    @Override
    public String toString() {
        return "Account" + account + " " + "Ruolo" + ruolo  + " ";
    }
}