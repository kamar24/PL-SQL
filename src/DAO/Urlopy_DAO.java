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
import java.sql.Date;
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
            Lekarze lekarz= new Lekarze();
            String imie_lek=rs.getString("imie");
            String nazwisko_lek=rs.getString("nazwisko");
           int id_urlopu = rs.getInt("id_urlopu");
            Date data_pocz=rs.getDate("data_pocz");
            Date data_konc=rs.getDate("data_konc");
            
            
            lekarz.setImie(imie_lek);
            lekarz.setNazwisko(nazwisko_lek);
           
           urlop.setId_urlopu(id_urlopu);
            urlop.setLekarze(lekarz);
            urlop.setData_pocz(data_pocz);
            urlop.setData_konc(data_konc);
            
            
            list.add(urlop);
           
        

    }   return list;
}


    public static void create(Urlopy r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertURLOPY(?,?,?)}");

        
        stmt.setInt(1, r.lekarze.getId_lekarza());
        stmt.setDate(2, r.getData_pocz());
        stmt.setDate(3, r.getData_konc());
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
       
        stmt.registerOutParameter(2, java.sql.Types.DATE);
        stmt.registerOutParameter(3, java.sql.Types.DATE);
     

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
        stmt.setDate(4, cz.getData_konc());
        stmt.setDate(4, cz.getData_pocz());
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.INTEGER);
        stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(4, java.sql.Types.VARCHAR);

        stmt.executeUpdate();

    }

    public Urlopy_DAO() {

    }
}

