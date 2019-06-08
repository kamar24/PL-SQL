/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Choroby;
import Models.Premie;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Premie_DAO {
    public List<Premie> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Premie> list = new ArrayList<Premie>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call getPREMIE(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Premie premia= new Premie();
            int id_premii = rs.getInt("id_premii");
            String nazwa = rs.getString("nazwa");
            Float wysokosc=rs.getFloat("wysokosc");
            
            premia.setId_premii(id_premii);
            premia.setNazwa(nazwa);
            premia.setWysokosc(wysokosc);
            
            list.add(premia);
        

    }   return list;
}


    public static void create(Premie r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertPremie(?,?)}");

        stmt.setInt(1, r.getId_premii());
        stmt.setString(2, r.getNazwa());
       
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
     

        stmt.executeUpdate();
    }

    public static void delete(Premie cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deletePREMIE(?)}");
        stmt.setInt(1, cz.getId_premii());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

    public static void update(Premie cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updatePREMIE(?,?)}");
        stmt.setInt(1, cz.getId_premii()); 
        stmt.setString(2, cz.getNazwa());
        
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

        stmt.executeUpdate();

    }

    public Premie_DAO() {

    }
}

