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
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author 80010-58-17
 */
public class ProduitDAO {

    public Connection con;
    ConnectSGBD sgbd = new ConnectSGBD();
    Produit p = new Produit();

    public ProduitDAO() throws SQLException {
        con = sgbd.GetConnect();
    }

    public List<Produit> List() throws SQLException {

        List<Produit> resultat = new ArrayList<Produit>();

        Statement stm = con.createStatement();

        ResultSet result = stm.executeQuery("SELECT * FROM produit");

        while (result.next()) {
            p = new Produit();
            p.setId(result.getInt("pro_id"));
            p.setLibCourt(result.getString("pro_libelle_court"));
            p.setLibLong(result.getString("pro_libelle_long"));
            p.setPhoto(result.getString("pro_photo"));
            p.setPrixAchat(result.getInt("pro_prix_achat"));
            p.setRubId(result.getInt("pro_rub_id"));
            p.setFouId(result.getInt("pro_fou_id"));
            resultat.add(p);
        }

        stm.close();
        result.close();
        con.close();

        return resultat;
    }

    public void Insert(Produit pro) throws SQLException {

        PreparedStatement stm = con.prepareStatement("Insert into produit (pro_libelle_court, pro_libelle_long, pro_prix_achat, pro_photo, pro_rub_id, pro_fou_id) values (?,?,?,?,?,?)");

        stm.setString(1, pro.getLibCourt());
        stm.setString(2, pro.getLibLong());
        stm.setDouble(3, pro.getPrixAchat());
        stm.setString(4, pro.getPhoto());
        stm.setInt(5, pro.getRubId());
        stm.setInt(6, pro.getFouId());

        stm.execute();

        stm.close();
        con.close();
    }

    public void Update(Produit pro) throws SQLException {

        PreparedStatement stm = con.prepareStatement("Update produit set pro_libelle_court=?, pro_libelle_long=?, pro_prix_achat=?, pro_photo=?, pro_rub_id=?, pro_fou_id=? where pro_id=?");

        stm.setString(1, pro.getLibCourt());
        stm.setString(2, pro.getLibLong());
        stm.setDouble(3, pro.getPrixAchat());
        stm.setString(4, pro.getPhoto());
        stm.setInt(5, pro.getRubId());
        stm.setInt(6, pro.getFouId());
        stm.setInt(7, pro.getId());

        stm.execute();

        stm.close();
        con.close();
    }

    public void Delete(Produit pro) throws SQLException {

        PreparedStatement stm = con.prepareStatement("DELETE from Produit WHERE pro_id=?;");

        stm.setInt(1, pro.getId());

        stm.execute();

        stm.close();
        con.close();
    }
}
