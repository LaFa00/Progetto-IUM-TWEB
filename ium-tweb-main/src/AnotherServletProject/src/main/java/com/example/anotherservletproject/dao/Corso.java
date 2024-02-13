package com.example.anotherservletproject.dao;
import java.util.Objects;

public class Corso {
    private String corso;
    private String ID_Corso;

    public Corso(String corso, String ID_Corso) {
        this.corso = corso;
        this.ID_Corso = ID_Corso;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public String getID_Corso() {
        return ID_Corso;
    }

    public void setID_Corso(String ID_Corso) {
        this.ID_Corso = ID_Corso;
    }

    @Override
    public String toString() {
        return corso + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corso corso1 = (Corso) o;
        return Objects.equals(corso, corso1.corso) && Objects.equals(ID_Corso, corso1.ID_Corso);
    }
}
