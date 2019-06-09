/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cho_Wiz;
import Models.Choroby;
import Models.Lek_Wiz;
import Models.Leki;
import Models.Wizyty;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class Lek_Wiz_DAO {
  public static List<Lek_Wiz> getLeki(int pomoc) throws SQLException, ParseException {
        Connection con = null;
        CallableStatement stmt = null;
        List<Lek_Wiz> getLeki = new ArrayList<Lek_Wiz>();
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call GETLEKI(?,?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, pomoc);
        
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);

        while (rs.next()) {
            Lek_Wiz lekwiz= new Lek_Wiz();
            Wizyty wizyta = new Wizyty();
            Leki lek = new Leki();
            wizyta.setId_wizyty(rs.getInt("id_wizyty"));
            lek.setNazwa(rs.getString("nazwa"));
            lekwiz.setWizyta(wizyta);
            lekwiz.setLek(lek);

            getLeki.add(lekwiz);
        }
        return getLeki;

    }

}
