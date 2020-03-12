/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hotelgui;

import com.mycompany.hotelDAO.Client;
import com.mycompany.hotelDAO.ClientDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class HotelGUIController implements Initializable {

    @FXML
    private TableView<Client> tab_client;
    @FXML
    private TableColumn<Client, String> tab_nom;
    @FXML
    private TableColumn<Client, String> tab_prenom;
    @FXML
    private AnchorPane pane_details;

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtVille;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TableColumn<Client, Integer> tab_id;
    private TableColumn<Client, String> tab_ville;

    List<Client> liste = new ArrayList<>();
    ClientDAO listeClient = new ClientDAO();

    ObservableList<Client> model = FXCollections.observableArrayList();
    public String action;
    Client c = new Client();
    int ligne;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pane_details.setVisible(false);

        initTab();
    }

    @FXML
    private void delete_client(ActionEvent event) {
        pane_details.setVisible(true);
        action = "delete";
        ligne = tab_client.getSelectionModel().getSelectedIndex();
        if (ligne > -1) {
            c = tab_client.getSelectionModel().getSelectedItem();
            Client cli = listeClient.Find(c.getId());
            txtNom.setText(cli.getNom());
            txtPrenom.setText(cli.getPrenom());
            txtVille.setText(cli.getVille());
        }

    }

    @FXML
    private void add_client(ActionEvent event) {
        pane_details.setVisible(true);
        action = "add";

    }

    @FXML
    private void update_client(ActionEvent event) {
        pane_details.setVisible(true);
        action = "update";
        ligne = tab_client.getSelectionModel().getSelectedIndex();
        if (ligne > -1) {
            c = tab_client.getSelectionModel().getSelectedItem();
            Client cli = listeClient.Find(c.getId());
            txtNom.setText(cli.getNom());
            txtPrenom.setText(cli.getPrenom());
            txtVille.setText(cli.getVille());
            c.setId(cli.getId());
        }
    }

    @FXML
    private void validate(ActionEvent event) {
        pane_details.setVisible(false);
        if ("add".equals(action)) {
            c.setNom(txtNom.getText());
            c.setPrenom(txtPrenom.getText());
            c.setVille(txtVille.getText());
            listeClient.Insert(c);
            initTab();
        } else if (action == "update") {
            c.setNom(txtNom.getText());
            c.setPrenom(txtPrenom.getText());
            c.setVille(txtVille.getText());
            listeClient.Update(c);
            System.out.println(c.getNom());
            initTab();

        } else if (action == "delete") {
            listeClient.Delete(c.getId());
            initTab();
        }
        clearText();

    }

    @FXML
    private void cancel(ActionEvent event) {
        pane_details.setVisible(false);
        clearText();
    }

    public void initTab() {
        model.clear();

        liste = listeClient.List();

        // méthode for classique
//        for (int i = 0; i < liste.size(); i++) {
//          model.add(new Client(liste.get(i).getNom(), liste.get(i).getPrenom()));
//        }
        //méthode raccourci
//        liste.forEach(regclient -> model.add(regclient));
        // méthode foreach java
        for (Client cli : liste) {
            model.add(cli);
        }

        //On rend le tableau non-éditable
        tab_client.setEditable(false);

        // Jonction du tableau avec les données 
        tab_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tab_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tab_id.setCellValueFactory(new PropertyValueFactory<>("id"));
//        tab_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));

        // On indique au TableView quelle modèle observer pour trouver les données
        tab_client.setItems(model);
    }

    public void clearText() {
        txtNom.clear();
        txtPrenom.clear();
        txtVille.clear();
    }

}
