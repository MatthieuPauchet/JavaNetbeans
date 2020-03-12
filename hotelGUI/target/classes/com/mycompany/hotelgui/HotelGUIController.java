/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class HotelGUIController implements Initializable {

    @FXML
    private TableView<?> tab_client;
    @FXML
    private TableColumn<?, ?> tab_nom;
    @FXML
    private TableColumn<?, ?> tab_prenom;
    @FXML
    private AnchorPane pane_details;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void delete_client(ActionEvent event) {
        pane_details.setVisible(true);
    }

    @FXML
    private void add_client(ActionEvent event) {
        pane_details.setVisible(true);
    }

    @FXML
    private void update_client(ActionEvent event) {
        pane_details.setVisible(true);
    }

    @FXML
    private void validate(ActionEvent event) {
        pane_details.setVisible(false);
    }

    @FXML
    private void cancel(ActionEvent event) {
        pane_details.setVisible(false);
    }

}
