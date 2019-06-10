/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Leki;
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
public class Leki_DAO {
   public List<Leki> getAll() throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Leki> list = new ArrayList<Leki>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETLEK(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Leki lek = new Leki();
            int id_leku = rs.getInt("id_leku");
            String nazwa = rs.getString("nazwa");
            
            
            lek.setId_leku(id_leku);
            lek.setNazwa(nazwa);
            
           

            list.add(lek);
        }

        return list;

    }

    public List<Leki> searchingOrderUser(String l) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Leki> lista = new ArrayList<Leki>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call SEARCHLEKI(?,?,?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        //statement.setInt(2, karnetyDAO.id);
        //statement.setString(3, l);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Leki lek = new Leki();

            int id_leku = rs.getInt("id_leku");
            String nazwa = rs.getString("nazwa");
                       

            lek.setId_leku(id_leku);
            lek.setNazwa(nazwa);
            
            

            lista.add(lek);
        }

        return lista;
    }

    public static void create(Leki k) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertLEKI(?)}");
        stmt.setString(1, k.getNazwa());
      
        

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        stmt.executeUpdate();
    }
    
    public static void update(Leki k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateLEKI(?,?,?)}");
        stmt.setInt(1, k.getId_leku());
        stmt.setString(2, k.getNazwa());
        ;
        

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
        
        
        stmt.executeUpdate();

    }
    
        public static void delete(Leki k) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteLEKI(?)}");
        stmt.setInt(1, k.getId_leku());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        
        stmt.executeUpdate();

    }
    public Leki_DAO() {

    }
}
