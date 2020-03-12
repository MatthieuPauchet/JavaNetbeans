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
public class FournisseurDAO {

    public Connection con;
    ConnectSGBD sgbd = new ConnectSGBD();
    Fournisseur f = new Fournisseur();

    public FournisseurDAO() throws SQLException {
        con = sgbd.GetConnect();
    }

    public List<Fournisseur> List() throws SQLException {

        List<Fournisseur> resultat = new ArrayList<Fournisseur>();

        Statement stm = con.createStatement();

        ResultSet result = stm.executeQuery("SELECT * FROM fournisseur");

        while (result.next()) {
            f = new Fournisseur();
            f.setId(result.getInt("fou_id"));
            f.setNom(result.getString("fou_nom"));
            f.setRue(result.getString("fou_rue"));
            f.setCodePostal(result.getString("fou_code_postal"));
            f.setVille(result.getString("fou_ville"));
            f.setPays(result.getString("fou_pays"));
            f.setMail(result.getString("fou_mail"));
            f.setTelephone(result.getString("fou_telephone"));
            f.setContactNom(result.getString("fou_contact_nom"));
            f.setContactTelephone(result.getString("fou_contact_telephone"));

            resultat.add(f);
        }

        stm.close();
        result.close();
        con.close();

        return resultat;
    }

    public Fournisseur FindByName(String nom) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * from Fournisseur WHERE fou_nom=?;");

        stm.setString(1, nom);

        ResultSet result = stm.executeQuery();

        result.next();

        f = new Fournisseur();
        f.setId(result.getInt("fou_id"));
        f.setNom(result.getString("fou_nom"));
        f.setRue(result.getString("fou_rue"));
        f.setCodePostal(result.getString("fou_code_postal"));
        f.setVille(result.getString("fou_ville"));
        f.setPays(result.getString("fou_pays"));
        f.setMail(result.getString("fou_mail"));
        f.setTelephone(result.getString("fou_telephone"));
        f.setContactNom(result.getString("fou_contact_nom"));
        f.setContactTelephone(result.getString("fou_contact_telephone"));

        stm.close();
        con.close();

        return f;
    }
    
    public Fournisseur FindById(int id) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * from Fournisseur WHERE fou_id=?;");

        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        result.next();

        f = new Fournisseur();
        f.setId(result.getInt("fou_id"));
        f.setNom(result.getString("fou_nom"));
        f.setRue(result.getString("fou_rue"));
        f.setCodePostal(result.getString("fou_code_postal"));
        f.setVille(result.getString("fou_ville"));
        f.setPays(result.getString("fou_pays"));
        f.setMail(result.getString("fou_mail"));
        f.setTelephone(result.getString("fou_telephone"));
        f.setContactNom(result.getString("fou_contact_nom"));
        f.setContactTelephone(result.getString("fou_contact_telephone"));

        stm.close();
        con.close();

        return f;
    }

}
