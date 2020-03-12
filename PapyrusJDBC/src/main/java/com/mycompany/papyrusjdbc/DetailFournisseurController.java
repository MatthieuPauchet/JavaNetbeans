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
public class DetailFournisseurController implements Initializable {

    @FXML
    private TextField numfou;
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
    @FXML
    private TitledPane paneInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void infoFournisseur(ActionEvent event) {
        try {
            // bien penser à télécharger la dépendence mysql et aller vérifier les requires 
            String url = "jdbc:mysql://127.0.0.1:3306/papyrus?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "");

            //Créer une requête prédéfinie sur la connexion con
            PreparedStatement stm = con.prepareStatement("SELECT nomfou, ruefou, posfou, confou, vilfou FROM fournis WHERE numfou=? ");
            try {

                int id = (Integer) parseInt(numfou.getText());

                //donner la valeur du paramètre pour l'exécution de la requête
                stm.setInt(1, id);
            } catch (Exception e) {
                numfou.setText("Il faut rentrer un nombre!!");
            }

            //exécution de la requête (lecture de la base)
            ResultSet result = stm.executeQuery();

            // on utilise un while pour parcourir le résultat
            while (result.next()) {
                paneInfo.setDisable(false);
                nomfou.setText(result.getString(1));
                ruefou.setText(result.getString(2));
                posfou.setText(result.getString(3));
                confou.setText(result.getString(4));
                vilfou.setText(result.getString(5));
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
    private void windowAdd(ActionEvent event) throws IOException {
        App.setRoot("ajoutFournisseur");
    }

    @FXML
    private void windowDetails(ActionEvent event) throws IOException {
        App.setRoot("detailsCommande");
    }

}
