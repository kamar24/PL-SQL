/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cho_Wiz;
import Models.Choroby;
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

/**
 *
 * @author Lukasz
 */
public class CHO_WIZ_DAO {

    

    public static List<Cho_Wiz> getchoroby(int pomoc) throws SQLException, ParseException {
        Connection con = null;
        CallableStatement stmt = null;
        List<Cho_Wiz> getchoroby = new ArrayList<Cho_Wiz>();
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call GETCHOWIZ(?,?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, pomoc);
        
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);

        while (rs.next()) {
            Cho_Wiz chowiz = new Cho_Wiz();
            Wizyty wizyta = new Wizyty();
            Choroby choroby = new Choroby();
           wizyta.setId_wizyty(rs.getInt("id_wizyty"));
            choroby.setNazwa(rs.getString("nazwa"));

            chowiz.setChoroba(choroby);
            chowiz.setWizyta(wizyta);

            getchoroby.add(chowiz);
        }
        return getchoroby;

    }

}
