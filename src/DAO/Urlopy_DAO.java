/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Urlopy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Urlopy_DAO {
    public List<Urlopy> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Urlopy> list = new ArrayList<Urlopy>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETURLOPY(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Urlopy urlop= new Urlopy();
            int id_urlopu = rs.getInt("id_urlopu");
            String data_pocz = rs.getString("data_pocz");
            String data_kon = rs.getString("data_kon");
            
            Lekarze lekarz = new Lekarze();
            int id_lekarza = rs.getInt("id_lekarza");
            String imie = rs.getString("imie");
            String nazwisko = rs.getString("nazwisko");
            lekarz.setImie(imie);
            lekarz.setNazwisko(nazwisko);

            urlop.setId_urlopu(id_urlopu);
            urlop.setLekarze(lekarz);
            urlop.setData_kon(data_kon);
            urlop.setData_pocz(data_pocz);

            
            list.add(urlop);
        

    }   return list;
}


    public static void create(Urlopy r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertURLOPY(?,?,?,?)}");

        stmt.setInt(1, r.getId_urlopu());
        stmt.setInt(2, r.lekarze.getId_lekarza());
        stmt.setString(3, r.getData_kon());
        stmt.setString(4, r.getData_pocz());
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
     

        stmt.executeUpdate();
    }

    public static void delete(Urlopy cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteUrlopy(?)}");
        stmt.setInt(1, cz.getId_urlopu());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

    public static void update(Urlopy cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateUrlopy(?,?,?,?)}");
        stmt.setInt(1, cz.getId_urlopu());
        stmt.setInt(2, cz.lekarze.getId_lekarza());
        stmt.setString(4, cz.getData_kon());
        stmt.setString(4, cz.getData_pocz());
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

        stmt.executeUpdate();

    }

    public Urlopy_DAO() {

    }
}

