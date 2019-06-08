/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Lekarze;
import Models.Choroby;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Choroby_DAO {

    public List<Choroby> getAll() throws SQLException, ParseException {

        Connection con = null;
        CallableStatement stmt = null;
        List<Choroby> list = new ArrayList<Choroby>();
        con = JDBC_Connection.getConnections();
        CallableStatement statement = con.prepareCall("{call GETCHOROBY(?)}");
        statement.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        statement.execute();
        ResultSet rs = (ResultSet) statement.getObject(1);

        while (rs.next()) {
            Choroby choroba = new Choroby();
            int id_choroby = rs.getInt("id_choroby");
            String nazwa = rs.getString("nazwa");

            choroba.setId_choroby(id_choroby);
            choroba.setNazwa(nazwa);

            list.add(choroba);

        }
        return list;
    }

    public static void create(Choroby r) throws SQLException {

        Connection con = null;
        CallableStatement stmt = null;

        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call insertChoroby(?)}");

        stmt.setString(1, r.getNazwa());

        stmt.registerOutParameter(1, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
    }

    public static void delete(Choroby cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call deleteCHOROBY(?)}");
        stmt.setInt(1, cz.getId_choroby());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);

        stmt.executeUpdate();

    }

    public static void update(Choroby cz) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call updateCHOROBY(?,?)}");
        stmt.setInt(1, cz.getId_choroby());
        stmt.setString(2, cz.getNazwa());

        stmt.registerOutParameter(1, java.sql.Types.INTEGER);
        stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

        stmt.executeUpdate();

    }

    public Choroby_DAO() {}
}
