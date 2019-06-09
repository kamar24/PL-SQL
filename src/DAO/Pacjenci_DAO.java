/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Pacjenci;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class Pacjenci_DAO {
        public List<Pacjenci> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Pacjenci> list = new ArrayList<Pacjenci>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETPACJENCI(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Pacjenci pacjent = new Pacjenci();

            int id_pacjenta = rs.getInt("id_pacjenta");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            String nr_tel = rs.getString("nr_tel");
            String pesel = rs.getString("pesel");
            String ulica = rs.getString("ulica");
            String kod_pocztowy = rs.getString("kod_pocztowy");
            String miasto = rs.getString("miasto");
            String ubezpieczenie = rs.getString("ubezpieczenie");
            

            
            pacjent.setId_pacjenta(id_pacjenta);
            pacjent.setImie(imie);
            pacjent.setNazwisko(nazwisko);
            pacjent.setNr_tel(nr_tel);
            pacjent.setPesel(pesel);
            pacjent.setUlica(ulica);
            pacjent.setKod_pocztowy(kod_pocztowy);
            pacjent.setMiasto(miasto);
            pacjent.setUbezpieczenie(ubezpieczenie);

            list.add(pacjent);
        }

        return list;

    }

    public static void create(Pacjenci k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertPACJENCI(?,?,?,?,?,?,?,?)}");
        stmt.setString(1, k.getImie());
        stmt.setString(2, k.getNazwisko());
        stmt.setString(3, k.getNr_tel());
        stmt.setString(4, k.getPesel());
        stmt.setString(5, k.getUlica());
        stmt.setString(6, k.getKod_pocztowy());
        stmt.setString(7, k.getMiasto());
        stmt.setString(8, k.getUbezpieczenie());
        
        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(8, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
    }

    public static void update(Pacjenci k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
         stmt = con.prepareCall("{call updatePacjenci(?,?,?,?,?,?,?,?,?)}");
        stmt.setString(1, k.getImie());
        stmt.setString(2, k.getNazwisko());
        stmt.setString(3, k.getNr_tel());
        stmt.setString(4, k.getPesel());
        stmt.setString(5, k.getUlica());
        stmt.setString(6, k.getKod_pocztowy());
        stmt.setString(7, k.getMiasto());
        stmt.setString(8, k.getUbezpieczenie());
        stmt.setInt(9, k.getId_pacjenta());
        
        
        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(6, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(7, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(8, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(9, java.sql.Types.INTEGER);

        stmt.executeUpdate();
    }
    
    public Pacjenci_DAO() {

    }
     public static void delete(Pacjenci cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call delPacjenci(?)}");
        
        stmt.setInt(1, cz.getId_pacjenta());
       
    
       stmt.executeUpdate();
}}

