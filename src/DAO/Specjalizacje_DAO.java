/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Oddzialy;
import Models.Specjalizacje;
import Models.Urlopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Specjalizacje_DAO {
    public List<Specjalizacje> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Specjalizacje> list = new ArrayList<Specjalizacje>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETSPECJALIZACJE(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Specjalizacje specjalizacja= new Specjalizacje();
            int id_specjalizacji = rs.getInt("id_specjalizacji");
            String nazwa = rs.getString("spec");
            
            Oddzialy oddzial=new Oddzialy();
                        
            oddzial.setNazwa(rs.getString("nazwa"));
          
           specjalizacja.setId_specjalizacji(id_specjalizacji);
            specjalizacja.setNazwa(nazwa);
            specjalizacja.setOddzialy(oddzial);

            
            list.add(specjalizacja);
        

    }   return list;
}


    public static void create(Specjalizacje r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertSPECJALIZACJe(?,?,?)}");

        stmt.setInt(1, r.getId_specjalizacji());
        stmt.setInt(2, r.oddzialy.getId_oddzialu());
        stmt.setString(3, r.getNazwa());
      

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
      
        stmt.executeUpdate();
    }

    public static void delete(Specjalizacje cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteSPECJALIZACJe(?)}");
        stmt.setInt(1, cz.getId_specjalizacji());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

    public static void update(Specjalizacje cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateSPECJALIZACJe(?,?,?)}");
        stmt.setInt(1, cz.getId_specjalizacji());
        stmt.setInt(2, cz.oddzialy.getId_oddzialu());
        stmt.setString(3, cz.getNazwa());
    
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
       
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

        stmt.executeUpdate();

    }

    public Specjalizacje_DAO() {

    }
}

