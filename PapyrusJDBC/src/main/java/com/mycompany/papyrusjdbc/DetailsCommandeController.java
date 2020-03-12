/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.papyrusjdbc;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class DetailsCommandeController implements Initializable {

    @FXML
    private ComboBox<String> choixFournisseur;
    @FXML
    private TextArea areaDetailCommande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // bien penser à télécharger la dépendence mysql et aller vérifier les requires 
            String url2 = "jdbc:mysql://127.0.0.1:3306/papyrus?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url2, "root", "");

            Statement stm = con.createStatement(); // création d'un objet requête directe

            //exécution de la requête (lecture de la base)
            ResultSet result = stm.executeQuery("SELECT nomfou FROM fournis");

            // on utilise un while pour alimenter l'observable liste de notre combobox
            while (result.next()) {
                choixFournisseur.getItems().add(result.getString(1));
            }

            //il est recommandé de fermer l'objet Statement
            stm.close();

            //et de fermer la connexion
            con.close();

        } catch (Exception e) {
            System.out.println("la connexion a échoué");
        }

    }

    @FXML
    private void backHome(ActionEvent event) throws IOException {

        App.setRoot("detailFournisseur");
    }

    @FXML
    private void selectCommand(ActionEvent event) {
        try {
            // bien penser à télécharger la dépendence mysql et aller vérifier les requires 
            String url2 = "jdbc:mysql://127.0.0.1:3306/papyrus?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url2, "root", "");

            PreparedStatement stm = con.prepareStatement("SELECT numcom,obscom,datcom FROM entcom JOIN fournis ON entcom.numfou=fournis.numfou WHERE fournis.nomfou=? ");
            try {

                String nom = choixFournisseur.getValue();

                //donner la valeur du paramètre pour l'exécution de la requête
                stm.setString(1, nom);

                //exécution de la requête (lecture de la base)
                ResultSet result = stm.executeQuery();
                areaDetailCommande.clear();
                // on utilise un while pour parcourir le résultat
                while (result.next()) {
                    areaDetailCommande.appendText(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + "\n");

                }

            } catch (Exception e) {
                areaDetailCommande.setText("la connexion a échouée");
            }

            //il est recommandé de fermer l'objet Statement
            stm.close();

            //et de fermer la connexion
            con.close();

        } catch (Exception e) {
            System.out.println("la connexion a échoué");
        }

    }

}
