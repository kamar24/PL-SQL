/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Pacjenci;
import Models.Wizyty;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Wizyty_DAO {
    
    

    public List<Wizyty> get_przyszle() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        
        List<Wizyty> list_get_przyszle = new ArrayList<Wizyty>();
        
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETWIZYTAPRZYSZLE(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Wizyty wizyta = new Wizyty();
            int id_wizyty=rs.getInt("id_wizyty");
            String objawy = rs.getString("objawy");
            Date nast_wizyta = rs.getDate("nast_wizyta");
            Date data_wizyty = rs.getDate("data_wizyty");

            Lekarze lekarz = new Lekarze();
            
            String imiel = rs.getString("lek_im");
            String nazwiskol = rs.getString("lek_nazw");
            lekarz.setImie(imiel);
            lekarz.setNazwisko(nazwiskol);

            Pacjenci pacjent = new Pacjenci();

            String imie_pac = rs.getString("imie");
            String nazwisko_pac = rs.getString("nazwisko");
            pacjent.setImie(imie_pac);
            pacjent.setNazwisko(nazwisko_pac);
            wizyta.setId_wizyty(id_wizyty);
            wizyta.setObjawy(objawy);
            wizyta.setData_wizyty(data_wizyty);
            wizyta.setNast_wizyta(nast_wizyta);
            wizyta.setLekarze(lekarz);
            wizyta.setPacjenci(pacjent);

            list_get_przyszle.add(wizyta);

        }
        return list_get_przyszle;
    }

    public List<Wizyty> get_obec() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Wizyty> list_get_obec = new ArrayList<Wizyty>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETWIZYTYOBEC(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Wizyty wizyta = new Wizyty();
            int id_wizyty=rs.getInt("Id_wizyty");
            String objawy = rs.getString("objawy");
            Date nast_wizyta = rs.getDate("nast_wizyta");
            Date data_wizyty = rs.getDate("data_wizyty");

            Pacjenci pacjent = new Pacjenci();

            String imie_pac = rs.getString("imie");
            String nazwisko_pac = rs.getString("nazwisko");
            pacjent.setImie(imie_pac);
            pacjent.setNazwisko(nazwisko_pac);

            Lekarze lekarz = new Lekarze();

            String imie_lek = rs.getString("lek_im");
            String nazwisko_lek = rs.getString("lek_naz");
            lekarz.setImie(imie_lek);
            lekarz.setNazwisko(nazwisko_lek);
            wizyta.setId_wizyty(id_wizyty);
            wizyta.setObjawy(objawy);
            wizyta.setData_wizyty(data_wizyty);
            wizyta.setNast_wizyta(nast_wizyta);
            wizyta.setLekarze(lekarz);
            wizyta.setPacjenci(pacjent);

            list_get_obec.add(wizyta);

        }
        return list_get_obec;
    }

    public List<Wizyty> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Wizyty> list = new ArrayList<Wizyty>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETWIZYTYPRZESZLE(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Wizyty wizyta = new Wizyty();
            int id_wizyty =rs.getInt("id_wizyty");
            String objawy = rs.getString("objawy");
            Date nast_wizyta = rs.getDate("nast_wizyta");
            Date data_wizyty = rs.getDate("data_wizyty");

            Pacjenci pacjent = new Pacjenci();
            String imie_pac = rs.getString("imie");
            String nazwisko_pac = rs.getString("nazwisko");
            pacjent.setId_pacjenta(id_wizyty);
            pacjent.setImie(imie_pac);
            pacjent.setNazwisko(nazwisko_pac);

            Lekarze lekarz = new Lekarze();
            String imie = rs.getString("im_lek");
            String nazwisko = rs.getString("naz_lek");
            lekarz.setImie(imie);
            lekarz.setNazwisko(nazwisko);
            
            wizyta.setId_wizyty(id_wizyty);
            wizyta.setObjawy(objawy);
            wizyta.setData_wizyty(data_wizyty);
            wizyta.setNast_wizyta(nast_wizyta);
            wizyta.setLekarze(lekarz);
            wizyta.setPacjenci(pacjent);

            list.add(wizyta);

        }
        return list;
    }

    public static void create(Wizyty r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertWIZ(?,?,?)}");

        stmt.setInt(1, r.lekarze.getId_lekarza());
        stmt.setInt(2, r.pacjenci.getId_pacjenta());
        stmt.setDate(3, r.getData_wizyty());
       

        stmt.executeUpdate();
        
       
    }

    public static void delete(Wizyty cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call DELWIZ(?)}");
        stmt.setInt(1, cz.getId_wizyty());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

   public static void update(Wizyty  k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call UPDATEWIZYTAOBECNA(?,?,?)}");
        stmt.setString(1, k.getObjawy());
        stmt.setDate(2, k.getNast_wizyta());
        stmt.setInt(3, k.getId_wizyty());
       
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.DATE);
        stmt.registerOutParameter(3, java.sql.Types.INTEGER);
        
    stmt.executeUpdate();
        
    }

    public Wizyty_DAO() {

    }
}
