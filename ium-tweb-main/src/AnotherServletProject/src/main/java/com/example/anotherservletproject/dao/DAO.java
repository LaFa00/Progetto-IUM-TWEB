package com.example.anotherservletproject.dao;
import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "";
    private static Connection conn = null;

    public static void registerDriver() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver correttamente registrato.");
        } catch (SQLException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static boolean prenotazioniIsEmpty() {
        boolean empty = true;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM prenotazioni");
            while(rd.next()) {
                empty = false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return empty;
        }

    }

    public static boolean disponibiliIsEmpty() {
        boolean empty = true;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM disponibili");
            while(rd.next()) {
                empty = false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return empty;
        }

    }

    public static boolean storicoIsEmpty() {
        boolean empty = true;
        try {
            conn = DriverManager.getConnection(url, user, password);
            if(conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM storico");
            while(rd.next()) {
                empty = false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return empty;
        }

    }

    public static ArrayList<Utente> getUtenti() {
        ArrayList<Utente> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM utente");
            while (rd.next()) {
                Utente u = new Utente(rd.getString("account"), rd.getString("password"), rd.getString("ruolo"), rd.getString("ID_Utente"));
                out.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<Utente> getUtente(String nome,String pass) {
        ArrayList<Utente> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM utente WHERE account='"+nome+"' AND password='"+pass+"'");
            while (rd.next()) {
                Utente u = new Utente(rd.getString("account"), rd.getString("password"), rd.getString("ruolo"), rd.getString("ID_Utente"));
                out.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }

    }



    public static ArrayList<Docente> getDocenti() {
        ArrayList<Docente> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM docenti");
            while (rd.next()) {
                Docente d = new Docente(rd.getString("NomeD"), rd.getString("CognomeD"), rd.getString("ID_D"));
                out.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<Docente> getDocenti(String NomeDocente,String CognomeDocente) {
        ArrayList<Docente> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM docenti WHERE NomeD='"+NomeDocente+"' AND CognomeD='"+CognomeDocente+"'");
            while (rd.next()) {
                Docente d = new Docente(rd.getString("NomeD"), rd.getString("CognomeD"), rd.getString("ID_D"));
                out.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<Corso> getCorsi() {
        ArrayList<Corso> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT DISTINCT * FROM corsi");
            while (rd.next()) {
                Corso c = new Corso(rd.getString("Corso"), rd.getString(("ID_Corso")));
                out.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<String> getGiorni(String corso){
        ArrayList<String> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT Giorno FROM disponibili WHERE Corso='"+corso+"'");
            while (rd.next()) {
                String day = rd.getString("Giorno");
                out.add(day);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    //Insegnamenti
    public static ArrayList<Insegnamento> getInsegnamento(){
        ArrayList<Insegnamento> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM insegnamento");
            while (rd.next()) {
                Insegnamento i = new Insegnamento(rd.getString("NomeDocente"), rd.getString("CognomeDocente"),rd.getString("ID_D"),rd.getString("NomeC"),rd.getString("ID_C"));
                out.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<Corso> getCorsi(String corso) {
        ArrayList<Corso> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM corsi WHERE Corso='"+corso+"'");
            while (rd.next()) {
                Corso c = new Corso(rd.getString("Corso"), rd.getString(("ID_Corso")));
                out.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }



    public static ArrayList<Disponibili> getDisponibili() {
        ArrayList<Disponibili> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT DISTINCT * FROM disponibili");
            while (rd.next()) {
                Disponibili d = new Disponibili(rd.getString("nomeDocente"), rd.getString("cognomeDocente"), rd.getString("ID_Docente"),
                        rd.getString("Corso"), rd.getString("ID_Corso"), rd.getString("Giorno"), rd.getString("Orario"), rd.getString("Available"));
                out.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return out;
    }

    public static ArrayList<Disponibili> getPrenotazioniDisponibili(String currentUser) {
        ArrayList<Disponibili> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT DISTINCT disponibili.* FROM disponibili, prenotazioni WHERE (disponibili.Orario != prenotazioni.Orario AND disponibili.Giorno = prenotazioni.Giorno OR disponibili.Giorno != prenotazioni.Giorno) AND prenotazioni.utente = '"+currentUser+"'");
            while (rd.next()) {
                Disponibili d = new Disponibili(rd.getString("nomeDocente"), rd.getString("cognomeDocente"), rd.getString("ID_Docente"),
                        rd.getString("Corso"), rd.getString("ID_Corso"), rd.getString("Giorno"), rd.getString("Orario"), rd.getString("Available"));
                out.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return out;
    }

    public static ArrayList<Prenotazioni> getPrenotazioni() {
        ArrayList<Prenotazioni> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT DISTINCT * FROM prenotazioni");
            while (rd.next()) {
                Prenotazioni p = new Prenotazioni(rd.getString("utente"), rd.getString("ID_Utente"), rd.getString("nomeDocente"), rd.getString("cognomeDocente"), rd.getString("ID_Docente"),
                        rd.getString("Corso"), rd.getString("ID_Corso"), rd.getString("Giorno"), rd.getString("Orario"), rd.getString("Available"));
                out.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }

    }

    public static ArrayList<Prenotazioni> getPrenotazioni(String available) {
        ArrayList<Prenotazioni> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM prenotazioni WHERE Available='"+available+"'");
            while (rd.next()) {
                Prenotazioni p = new Prenotazioni(rd.getString("utente"), rd.getString("ID_Utente"), rd.getString("nomeDocente"), rd.getString("cognomeDocente"), rd.getString("ID_Docente"),
                        rd.getString("Corso"), rd.getString("ID_Corso"), rd.getString("Giorno"), rd.getString("Orario"), rd.getString("Available"));

                out.add(p);
            }
            System.out.println("Array Prenotazioni: " + out.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static void insertCorso(String corso,String ID_Corso) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO corsi (Corso,ID_Corso) VALUES('"+corso+"', '"+ID_Corso+"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCorso(String corso) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM corsi WHERE Corso='"+corso+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertDocente(String nome,String cognome, String ID) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO docenti (NomeD,CognomeD,ID_D) VALUES('"+nome+"', '"+cognome+"','"+ID+"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteDocente(String ID) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM docenti where ID_D='"+ID+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCattedra(String Nome, String Cognome, String ID_Docente,String Corso, String ID_Corso) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO insegnamento (NomeDocente,CognomeDocente,ID_D,ID_C,NomeC) VALUES('"+Nome+"', '"+Cognome+"','"+ID_Docente+"','"+ID_Corso+"','"+Corso+"')");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteCattedra(String ID_Docente,String ID_Corso) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM insegnamento WHERE ID_D='"+ID_Docente+"' AND ID_C='"+ID_Corso+"'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean isInStorico(String utente, String ID_Utente, String nomeDocente, String cognomeDocente, String ID_Docente,String  Corso, String ID_Corso, String Giorno, String Orario, String Available) {
        boolean isInTable = false;
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM storico WHERE Utente='"+utente+"' AND ID_Utente='"+ID_Utente+"' AND NomeDocente='"+nomeDocente+"' AND CognomeDocente='"+cognomeDocente+"' AND ID_Docente='"+ID_Docente+"'" +
                    "AND Corso='"+Corso+"' AND ID_Corso='"+ID_Corso+"' AND Giorno='"+Giorno+"' AND Orario='"+Orario+"' AND Available='"+Available+"'");
            while(rd.next()) {
                isInTable = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isInTable;
    }

    public static boolean isInDisponibili(String nomeDocente, String cognomeDocente, String ID_Docente,String  Corso, String ID_Corso, String Giorno, String Orario, String Available) {
        boolean isInTable = false;
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM disponibili WHERE  NomeDocente='"+nomeDocente+"' AND CognomeDocente='"+cognomeDocente+"' AND ID_Docente='"+ID_Docente+"'" +
                    "AND Corso='"+Corso+"' AND ID_Corso='"+ID_Corso+"' AND Giorno='"+Giorno+"' AND Orario='"+Orario+"' AND Available='"+Available+"'");
            while(rd.next()) {
                isInTable = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isInTable;
    }

    public static boolean isInPrenotazioni(String utente, String ID_Utente, String nomeDocente, String cognomeDocente, String ID_Docente,String  Corso, String ID_Corso, String Giorno, String Orario, String Available) {
        boolean isInTable = false;
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM prenotazioni WHERE Utente='"+utente+"' AND ID_Utente='"+ID_Utente+"' AND NomeDocente='"+nomeDocente+"' AND CognomeDocente='"+cognomeDocente+"' AND ID_Docente='"+ID_Docente+"'" +
                    "AND Corso='"+Corso+"' AND ID_Corso='"+ID_Corso+"' AND Giorno='"+Giorno+"' AND Orario='"+Orario+"' AND Available='"+Available+"'");
            while(rd.next()) {
                isInTable = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isInTable;
    }

    public static String insertPrenotazioni(String utente, String ID_Utente, String nomeDocente, String cognomeDocente, String ID_Docente, String corso, String ID_Corso, String giorno, String orario, String available) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            System.out.println("PIPPO INSERT PRENOTAZIONI");
            if(prenotazioniIsEmpty() == true && storicoIsEmpty() == true && disponibiliIsEmpty() == true) {
                Statement st = conn.createStatement();
                //System.out.println("Utente : "+utente+", ID_Utente : "+ID_Utente+", NomeDoc : "+nomeDocente+", CognomeDoc : "+cognomeDocente);
                st.executeUpdate("INSERT INTO prenotazioni (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                            + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "','" + available + "')");
                st.executeUpdate("INSERT INTO storico (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                        + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "','" + available + "')");
                return "Prenotazione Inserita";

            } else {
                if(isInPrenotazioni(utente,ID_Utente,nomeDocente,cognomeDocente,ID_Docente,corso,ID_Corso,giorno,orario,available) && isInStorico(utente,ID_Utente,nomeDocente,cognomeDocente,ID_Docente,corso,ID_Corso,giorno,orario,available)) {
                    System.out.println("Prenotazione già inserita");
                    //System.out.println("Utente : "+utente+", ID_Utente : "+ID_Utente+", NomeDoc : "+nomeDocente+", CognomeDoc : "+cognomeDocente);
                    return "Fallimento nell'inserire la prenotazione voluta";
                } else {
                    Statement st = conn.createStatement();
                    System.out.println("Utente : "+utente+", ID_Utente : "+ID_Utente+", NomeDoc : "+nomeDocente+", CognomeDoc : "+cognomeDocente+", Corso : "+corso+" , Stato Prenotazione : "+available);
                    st.executeUpdate("INSERT INTO prenotazioni (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                            + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "','" + available + "')");
                    st.executeUpdate("INSERT INTO storico (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                            + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "','" + available + "')");
                    st.executeUpdate("DELETE FROM disponibili WHERE ID_Docente='"+ID_Docente+"' AND ID_Corso='"+ID_Corso+"' AND Giorno='"+giorno+"' AND Orario='"+orario+"'");
                    return "Prenotazione Inserita Correttamente!";

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Error" + e.getMessage();
        }
    }

    public static void deletePrenotazioni(String utente, String ID_Utente, String nomeDocente, String cognomeDocente, String ID_Docente, String corso, String ID_Corso, String giorno,String orario) {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database test");
            }
            Statement st = conn.createStatement();
            if(disponibiliIsEmpty() == true && storicoIsEmpty() == true) {
                st.executeUpdate("DELETE FROM prenotazioni WHERE Utente='" + utente + "' AND ID_Utente='" + ID_Utente + "' AND NomeDocente='" + nomeDocente + "' AND CognomeDocente='" + cognomeDocente + "' AND ID_Docente='" + ID_Docente + "' AND Corso='" + corso + "' AND ID_Corso='" + ID_Corso + "' AND Giorno='" + giorno + "' AND Orario='" + orario + "' AND Available='Effettuata'");
                st.executeUpdate("INSERT INTO storico (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                        + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "', 'disdetta')");
                st.executeUpdate("INSERT INTO disponibili (NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                        + "('" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "', 'disponibile')");
            } else {
                if(isInDisponibili(nomeDocente,cognomeDocente,ID_Docente,corso,ID_Corso,giorno,orario,"disponibile")) {
                    System.out.println("Già presente in disponibili");
                } else {
                    st.executeUpdate("DELETE FROM prenotazioni WHERE Utente='" + utente + "' AND ID_Utente='" + ID_Utente + "' AND NomeDocente='" + nomeDocente + "' AND CognomeDocente='" + cognomeDocente + "' AND ID_Docente='" + ID_Docente + "' AND Corso='" + corso + "' AND ID_Corso='" + ID_Corso + "' AND Giorno='" + giorno + "' AND Orario='" + orario + "' AND Available='Effettuata'");
                    st.executeUpdate("INSERT INTO storico (Utente,ID_Utente,NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                            + "('" + utente + "', '" + ID_Utente + "','" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "', 'disdetta')");
                    st.executeUpdate("INSERT INTO disponibili (NomeDocente,CognomeDocente,ID_Docente,Corso,ID_Corso,Giorno,Orario,Available) VALUES"
                            + "('" + nomeDocente + "','" + cognomeDocente + "','" + ID_Docente + "','" + corso + "','" + ID_Corso + "','" + giorno + "','" + orario + "', 'disponibile')");
                }
            }
                } catch (SQLException e) {

                    System.out.println(e.getMessage());
                }
    }

    public static ArrayList<Prenotazioni> getPrenotazioni(String utente, String id) {
        ArrayList<Prenotazioni> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url,user,password);
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM prenotazioni WHERE Utente='"+utente+"' AND ID_Utente='"+id+"'");
            while(rd.next()) {
                Prenotazioni p = new Prenotazioni(rd.getString("Utente"), rd.getString("ID_Utente"),rd.getString("NomeDocente"),rd.getString("CognomeDocente"),rd.getString("ID_Docente"),rd.getString("Corso"),rd.getString("ID_Corso"),rd.getString("Giorno"),rd.getString("Orario"),rd.getString("Available"));
                System.out.println("Prenotazione p: " + p.toString());
                out.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return out;
    }

    public static ArrayList<Prenotazioni> getPrenotazione(String utente,String id, String NomeDocente, String CognomeDocente) {
        ArrayList<Prenotazioni> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT * FROM prenotazioni WHERE Utente='"+utente+"' AND ID_Utente='"+id+"' AND NomeDocente='"+NomeDocente+"' AND CognomeDocente='"+CognomeDocente+"'");
            while (rd.next()) {
                Prenotazioni p = new Prenotazioni(rd.getString("Utente"), rd.getString("ID_Utente"),rd.getString("NomeDocente"),rd.getString("CognomeDocente"),rd.getString("ID_Docente"),rd.getString("Corso"),rd.getString("ID_Corso"),rd.getString("Giorno"),rd.getString("Orario"),rd.getString("Available"));
                out.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }


    }

    public static ArrayList<String> getOrari(String corso, String giorno) {
        ArrayList<String> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            ResultSet rd = st.executeQuery("SELECT Orario FROM disponibili WHERE Corso='"+corso+"' AND Giorno='"+giorno+"'");
            while (rd.next()) {
                String hour = rd.getString("Orario");
                out.add(hour);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }

    public static ArrayList<Storico> getStorico(String user) {
        ArrayList<Storico> out = new ArrayList<>();
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null)
                System.out.println("Connected to the database");
            Statement st = conn.createStatement();
            if(user.equals("admin")){
                ResultSet rd = st.executeQuery("SELECT * FROM storico");
                while (rd.next()) {
                    //utente, ID_Utente, nomeDocente, cognomeDocente, ID_Docente, corso, ID_Corso, giorno, orario, available
                    Storico stor = new Storico(rd.getString("utente"), rd.getString("ID_Utente"), rd.getString("nomeDocente"),rd.getString("cognomeDocente"), rd.getString("ID_Docente"), rd.getString("corso"), rd.getString("ID_Corso"), rd.getString("giorno"), rd.getString("orario"), rd.getString("available"));
                    out.add(stor);
                }
            }else if(!user.equals("")){
                ResultSet rd = st.executeQuery("SELECT * FROM storico WHERE Utente='"+user+"'");
                while (rd.next()) {
                    Storico stor = new Storico(rd.getString("utente"), rd.getString("ID_Utente"), rd.getString("nomeDocente"),rd.getString("cognomeDocente"), rd.getString("ID_Docente"), rd.getString("corso"), rd.getString("ID_Corso"), rd.getString("giorno"), rd.getString("orario"), rd.getString("available"));
                    out.add(stor);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return out;
        }
    }
}