/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-58-17
 */
public class RubriqueDAO {

    public Connection con;
    ConnectSGBD sgbd = new ConnectSGBD();
    Rubrique r = new Rubrique();

    public RubriqueDAO() throws SQLException{
        con = sgbd.GetConnect();
    }
    
    public List<Rubrique> ListSsRub() throws SQLException {

        List<Rubrique> resultat = new ArrayList<Rubrique>();

        Statement stm = con.createStatement();

        ResultSet result = stm.executeQuery("SELECT * FROM rubrique where rub_id_1 is not Null");

        while (result.next()) {
            r = new Rubrique();
            r.setId(result.getInt("rub_id"));
            r.setNom(result.getString("rub_nom"));
            r.setLibelle(result.getString("rub_libelle"));
            r.setPhoto(result.getString("rub_photo"));
            r.setId1(result.getInt("rub_id_1"));
            resultat.add(r);
        }

        stm.close();
        result.close();
        con.close();

        return resultat;
    }
    
    public Rubrique FindByName(String nom) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * from Rubrique WHERE rub_nom=?;");

        stm.setString(1, nom);

        ResultSet result = stm.executeQuery();

        result.next();

        r.setId(result.getInt("rub_id"));
        r.setNom(result.getString("rub_nom"));
        r.setLibelle(result.getString("rub_libelle"));
        r.setPhoto(result.getString("rub_photo"));
        r.setId1(result.getInt("rub_id_1"));

        stm.close();
        con.close();

        return r;
    }
    
    public Rubrique FindById(int id) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * from Rubrique WHERE rub_id=?;");

        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        result.next();

        r.setId(result.getInt("rub_id"));
        r.setNom(result.getString("rub_nom"));
        r.setLibelle(result.getString("rub_libelle"));
        r.setPhoto(result.getString("rub_photo"));
        r.setId1(result.getInt("rub_id_1"));

        stm.close();
        con.close();

        return r;
    }

}
