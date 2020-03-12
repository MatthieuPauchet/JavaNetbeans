/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.papyrusjdbc;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class AjoutFournisseurController implements Initializable {

    @FXML
    private TitledPane paneInfo;
    @FXML
    private TextField nomfou;
    @FXML
    private TextField ruefou;
    @FXML
    private TextField posfou;
    @FXML
    private TextField confou;
    @FXML
    private TextField vilfou;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backHome(ActionEvent event) throws IOException {

        App.setRoot("detailFournisseur");
    }

    @FXML
    private void addSupplier(ActionEvent event) throws SQLException {
        String founom = nomfou.getText();
        String fourue = ruefou.getText();
        String foupos = posfou.getText();
        String foucon = confou.getText();
        String fouvil = vilfou.getText();
        try {
            // bien penser à télécharger la dépendence mysql et aller vérifier les requires 
            String url2 = "jdbc:mysql://127.0.0.1:3306/papyrus?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url2, "root", "");

            // création d'un objet de la classe Statement qui permet d'effectuer des requêtes liées à la connexion 'con'
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT MAX(numfou) FROM fournis");

            // Exploitation du résultat de la requête
            res.next();
            int i = res.getInt(1) + 1;

            res.close();
            stm.close();
            // il est recommandé de fermer le resultset
            //même si le garbage collector fait le travail quand même.

            PreparedStatement stm2 = con.prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) VALUES (?, ?, ?, ?, ?, ?)");

            stm2.setInt(1, i);
            stm2.setString(2, founom);
            stm2.setString(3, fourue);
            stm2.setString(4, fouvil);
            stm2.setString(5, foupos);
            stm2.setString(6, foucon);

            stm2.execute();
            //il est recommandé de fermer l'objet Statement et de fermer la connexion
            stm2.close();
            con.close();

            nomfou.clear();
            ruefou.clear();
            posfou.clear();
            confou.clear();
            vilfou.clear();

        } catch (Exception e) {
            System.out.println("la connexion a échoué");
        }

    }

}
