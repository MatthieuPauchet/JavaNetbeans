/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class AccueilController implements Initializable {

    @FXML
    private Label lbl_gestionClients;
    @FXML
    private Label lbl_gestionProduits;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_client_click(ActionEvent event) throws IOException {
                App.setRoot("Client");
    }

    @FXML
    private void btn_produit_click(ActionEvent event) throws IOException {
                App.setRoot("Produit");
    }
    
}
