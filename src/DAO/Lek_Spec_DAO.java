/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Cho_Wiz;
import Models.Choroby;
import Models.Lek_Spec;
import Models.Lek_Wiz;
import Models.Lekarze;
import Models.Leki;
import Models.Specjalizacje;
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
public class Lek_Spec_DAO {
    public static List<Lek_Spec> getspec_lek(int pomoc) throws SQLException, ParseException {
        Connection con = null;
        CallableStatement stmt = null;
        List<Lek_Spec> getspec_lek = new ArrayList<Lek_Spec>();
        con = JDBC_Connection.getConnections();
        stmt = con.prepareCall("{call getLEKSPEC(?,?)}");
        stmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
        stmt.setInt(2, pomoc);
        
        stmt.execute();
        ResultSet rs = (ResultSet) stmt.getObject(1);

        while (rs.next()) {
            Lek_Spec lekspec=new Lek_Spec();
            Specjalizacje specjalizacja=new Specjalizacje();
            Lekarze lekarz= new Lekarze();
            
            specjalizacja.setNazwa(rs.getString("Nazwa"));
            lekarz.setImie(rs.getString("imie"));
            lekarz.setNazwisko(rs.getString("nazwisko"));
            lekarz.setPesel(rs.getString("pesel"));
            
            lekspec.setLekarz(lekarz);
            lekspec.setSpecjalizacja(specjalizacja);

            getspec_lek.add(lekspec);
        }
        return getspec_lek;

    }
}
