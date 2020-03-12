/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Matthieu Pauchet Février 2020
 */
public class ClientDAO {

    public Connection con;
    Client c = new Client();
    ConnectSGBD sgbd = new ConnectSGBD();

    public ClientDAO() throws SQLException {
        con = sgbd.GetConnect();
    }

    public List<Client> List() throws SQLException {

        List<Client> resultat = new ArrayList<Client>();

        Statement stm = con.createStatement();

        ResultSet result = stm.executeQuery("SELECT * FROM client");

        while (result.next()) {
            c = new Client();
            c.setCli_id(result.getInt("cli_id"));
            c.setCli_nom(result.getString("cli_nom"));
            c.setCli_prenom(result.getString("cli_prenom"));
            c.setCli_rue(result.getString("cli_rue"));
            c.setCli_code_postal(result.getString("cli_code_postal"));
            c.setCli_ville(result.getString("cli_ville"));
            c.setCli_pays(result.getString("cli_pays"));
            c.setCli_mail(result.getString("cli_mail"));
            c.setCli_password(result.getString("cli_password"));
            c.setCli_telephone(result.getString("cli_telephone"));
            c.setCli_statut(result.getString("cli_statut"));
            c.setCli_coefficient(result.getInt("cli_coefficient"));

            resultat.add(c);
        }

        stm.close();
        result.close();
        con.close();

        return resultat;

    }

    public void Insert(Client cli) throws SQLException {

        PreparedStatement stm = con.prepareStatement("Insert into client (cli_nom, cli_prenom, cli_rue, cli_code_postal, cli_ville, cli_pays, cli_mail, cli_telephone, cli_statut, cli_coefficient) values (?,?,?,?,?,?,?,?,?,?)");

        stm.setString(1, cli.getCli_nom());
        stm.setString(2, cli.getCli_prenom());
        stm.setString(3, cli.getCli_rue());
        stm.setString(4, cli.getCli_code_postal());
        stm.setString(5, cli.getCli_ville());
        stm.setString(6, cli.getCli_pays());
        stm.setString(7, cli.getCli_mail());
        stm.setString(8, cli.getCli_telephone());
        stm.setString(9, cli.getCli_statut());
        stm.setInt(10, cli.getCli_coefficient());

        stm.execute();

        stm.close();
        con.close();
    }

    public void Update(Client cli) throws SQLException {

        PreparedStatement stm = con.prepareStatement("Update client set cli_nom=?, cli_prenom=?, cli_rue=?, cli_code_postal=?, cli_ville=?, cli_pays=?, cli_mail=?, cli_telephone=?, cli_statut=?, cli_coefficient=? where cli_id=?");

        stm.setString(1, cli.getCli_nom());
        stm.setString(2, cli.getCli_prenom());
        stm.setString(3, cli.getCli_rue());
        stm.setString(4, cli.getCli_code_postal());
        stm.setString(5, cli.getCli_ville());
        stm.setString(6, cli.getCli_pays());
        stm.setString(7, cli.getCli_mail());
        stm.setString(8, cli.getCli_telephone());
        stm.setString(9, cli.getCli_statut());
        stm.setInt(10, cli.getCli_coefficient());
        stm.setInt(11, cli.getCli_id());

        stm.execute();

        stm.close();
        con.close();
    }

    public void Delete(Client cli) throws SQLException {

        PreparedStatement stm = con.prepareStatement("DELETE from Client WHERE cli_id=?;");

        stm.setInt(1, cli.getCli_id());

        stm.execute();

        stm.close();
        con.close();
    }

    public Client Find(int id) throws SQLException {

        PreparedStatement stm = con.prepareStatement("SELECT * from Client WHERE cli_id=?;");

        stm.setInt(1, id);

        ResultSet result = stm.executeQuery();

        result.next();

        c.setCli_id(result.getInt("cli_id"));
        c.setCli_nom(result.getString("cli_nom"));
        c.setCli_prenom(result.getString("cli_prenom"));
        c.setCli_rue(result.getString("cli_rue"));
        c.setCli_code_postal(result.getString("cli_code_postal"));
        c.setCli_ville(result.getString("cli_ville"));
        c.setCli_pays(result.getString("cli_pays"));
        c.setCli_mail(result.getString("cli_mail"));
        c.setCli_password(result.getString("cli_password"));
        c.setCli_telephone(result.getString("cli_telephone"));
        c.setCli_statut(result.getString("cli_statut"));
        c.setCli_coefficient(result.getInt("cli_coefficient"));

        stm.close();
        con.close();

        return c;
    }

}
