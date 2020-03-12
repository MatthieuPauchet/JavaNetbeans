/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author M Pauchet
 */
public class ClientDAO {

    public ClientDAO() {
    }

    public Connection ConnectSGBD() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
        Connection con = DriverManager.getConnection(url, "root", "");
        return con;
    }

    public void Insert(Client cli) {

        try {
            Connection con = ConnectSGBD();

            PreparedStatement stm = con.prepareStatement("Insert into client (cli_nom, cli_prenom, cli_ville) values (?,?,?)");

            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());

            stm.execute();

            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(ex.getMessage());
        }
    }

    public void Update(Client cli) {

        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement stm = con.prepareStatement("UPDATE client SET  cli_nom=?, cli_prenom=?, cli_ville=? WHERE cli_id=?;");

            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());
            stm.setInt(4, cli.getId());

            stm.execute();

            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(ex.getMessage());
        }
    }

    public void Delete(int id) {
        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement stm = con.prepareStatement("DELETE from Client WHERE cli_id=?;");

            stm.setInt(1, id);

            stm.execute();

            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(ex.getMessage());
        }
    }

    public Client Find(int id) {

        Client c = new Client();

        try {
            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");

            PreparedStatement stm = con.prepareStatement("SELECT * from Client WHERE cli_id=?;");

            stm.setInt(1, id);

            ResultSet result = stm.executeQuery();

            result.next();

            c.setId(result.getInt("cli_id"));
            c.setNom(result.getString("cli_nom"));
            c.setPrenom(result.getString("cli_prenom"));
            c.setVille(result.getString("cli_ville"));

            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(ex.getMessage());
        }
        return c;

    }

    public List<Client> List() {

        List<Client> resultat = new ArrayList<Client>();
        try {

//            String url = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "");
            Connection con = ConnectSGBD();

            Statement stm = con.createStatement();

            ResultSet result = stm.executeQuery("SELECT * FROM client");

            while (result.next()) {
                Client c = new Client();
                c.setId(result.getInt("cli_id"));
                c.setNom(result.getString("cli_nom"));
                c.setPrenom(result.getString("cli_prenom"));
//                c.setVille(result.getString("cli_ville"));

                resultat.add(c);
            }

            stm.close();
            result.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error while reading 'client'");
            System.out.println(e.getMessage());
        }

        return resultat;

    }

}
