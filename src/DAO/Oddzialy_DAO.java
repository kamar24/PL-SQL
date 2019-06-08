/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Oddzialy;
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
public class Oddzialy_DAO {
   public List<Oddzialy> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Oddzialy> list = new ArrayList<Oddzialy>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETODDZIALY(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Oddzialy oddzial = new Oddzialy();
            int id_oddzialu = rs.getInt("id_oddzialu");
            String nazwa = rs.getString("nazwa");
           
            
            oddzial.setId_oddzialu(id_oddzialu);
            oddzial.setNazwa(nazwa);
           

            list.add(oddzial);
        }

        return list;

    }

    public List<Oddzialy> searchingOrderUser(String l) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Oddzialy> lista = new ArrayList<Oddzialy>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call SEARCHODDZIALY(?,?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        //statement.setInt(2, karnetyDAO.id);
        //statement.setString(3, l);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Oddzialy oddzial = new Oddzialy();

            int id_oddzialu = rs.getInt("id_oddzialu");
            String nazwa = rs.getString("nazwa");
            
            

            oddzial.setId_oddzialu(id_oddzialu);
            oddzial.setNazwa(nazwa);;
            

            lista.add(oddzial);
        }

        return lista;
    }

    public static void create(Oddzialy k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call inserLEKI(?,?)}");
        stmt.setString(1, k.getNazwa());
        
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        
        
        stmt.executeUpdate();
    }
    
    public static void update(Oddzialy k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateKARNETY(?,?)}");
        stmt.setInt(1, k.getId_oddzialu());
        stmt.setString(2, k.getNazwa());
       
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        
        stmt.executeUpdate();

    }
    
        public static void delete(Oddzialy k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteLEKI(?)}");
        stmt.setInt(1, k.getId_oddzialu());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        
        stmt.executeUpdate();

    }
    public Oddzialy_DAO() {

    }
}
