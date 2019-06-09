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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class Lekarze_DAO {
    public List<Lekarze> getChoiceBox() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Lekarze> list = new ArrayList<Lekarze>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETLEKARZECHOICEBOX(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Lekarze lekarz = new Lekarze();

            int id_lekarza = rs.getInt("Id_lekarza");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
          
            String pesel = rs.getString("pesel");
            
                                
            lekarz.setId_lekarza(id_lekarza);
            lekarz.setImie(imie);
            lekarz.setNazwisko(nazwisko);
          
            lekarz.setPesel(pesel);
           
            
           
                
            list.add(lekarz);
            
        }
        
        return list;

    }
        public List<Lekarze> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Lekarze> list = new ArrayList<Lekarze>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETLEKARZE(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Lekarze lekarz = new Lekarze();

            int id_lekarza = rs.getInt("Id_lekarza");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            String nr_tel = rs.getString("nr_tel");
            String pesel = rs.getString("pesel");
            int nr_gab = rs.getInt("nr_gabinetu");
            int wynagrodzenie = rs.getInt("wynagrodzenie");
            Date data_zat = rs.getDate("data_zat");
                                
            lekarz.setId_lekarza(id_lekarza);
            lekarz.setImie(imie);
            lekarz.setNazwisko(nazwisko);
            lekarz.setNr_tel(nr_tel);
            lekarz.setPesel(pesel);
            lekarz.setNr_gabinetu(nr_gab);
            
            lekarz.setWynagrodzenie(wynagrodzenie);
            lekarz.setData_zat(data_zat);
                
            list.add(lekarz);
            
        }
        
        return list;

    }

    public static void create(Lekarze k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertLEKARZ(?,?,?,?,?,?,?)}");
        stmt.setString(1, k.getImie());
        stmt.setString(2, k.getNazwisko());
        stmt.setString(3, k.getNr_tel());
        stmt.setInt(4, k.getWynagrodzenie());
        
        stmt.setString(5, k.getPesel());
        stmt.setInt(6, k.getNr_gabinetu());
        stmt.setDate(7, k.getData_zat());
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.INTEGER);
        
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(6, java.sql.Types.INTEGER);
        stmt.registerOutParameter(7, java.sql.Types.DATE);
        
    stmt.executeUpdate();
        
    }
    public static void update(Lekarze  k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call UPDATELEKARZ(?,?,?,?,?,?,?,?)}");
        stmt.setString(1, k.getImie());
        stmt.setString(2, k.getNazwisko());
        stmt.setString(3, k.getNr_tel());
        stmt.setInt(4, k.getWynagrodzenie());
        stmt.setString(5, k.getPesel());
        stmt.setInt(6, k.getNr_gabinetu());
        stmt.setDate(7, k.getData_zat());
        stmt.setInt(8, k.getId_lekarza());
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.INTEGER);
        
        stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(6, java.sql.Types.INTEGER);
        stmt.registerOutParameter(7, java.sql.Types.DATE);
        stmt.registerOutParameter(8, java.sql.Types.INTEGER);
        
    stmt.executeUpdate();
        
    }
    
     public static void delete(Lekarze cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call delLEKARZ(?)}");
        
        stmt.setInt(1, cz.getId_lekarza());
       
     
       stmt.executeUpdate();
      

        

    }

  
    
    public Lekarze_DAO() {

    }

}

