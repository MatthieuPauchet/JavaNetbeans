/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage;

import DAL.Client;
import DAL.ClientDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class ClientController implements Initializable {

    @FXML
    private AnchorPane pane_Clients;
    @FXML
    private TableView<Client> tab_clients;
    @FXML
    private TableColumn<Client, String> tabc_nom;
    @FXML
    private TableColumn<Client, String> tabc_prenom;
    @FXML
    private TableColumn<Client, String> tabc_ville;
    @FXML
    private TableColumn<Client, String> tabc_telephone;
    @FXML
    private Pane pane_form;
    @FXML
    private TextField txt_cli_id;
    @FXML
    private TextField txt_cli_telephone;
    @FXML
    private TextField txt_cli_pays;
    @FXML
    private TextField txt_cli_rue;
    @FXML
    private TextField txt_cli_status;
    @FXML
    private TextField txt_cli_mail;
    @FXML
    private TextField txt_cli_code_postal;
    @FXML
    private TextField txt_cli_nom;
    @FXML
    private Label lbl_cli_id;
    @FXML
    private Label lbl_cli_ville;
    @FXML
    private Label lbl_cli_statut;
    @FXML
    private Label lbl_cli_mail;
    @FXML
    private Label lbl_cli_code_postal;
    @FXML
    private Label lbl_cli_nom;
    @FXML
    private Label lbl_cli_telephone;
    @FXML
    private Label lbl_cli_pays;
    @FXML
    private Label lbl_cli_rue;
    @FXML
    private TextField txt_cli_coefficient;
    @FXML
    private TextField txt_cli_password;
    @FXML
    private TextField txt_cli_ville;
    @FXML
    private TextField txt_cli_prenom;
    @FXML
    private Label lbl_cli_coefficient;
    @FXML
    private Label lbl_cli_password;
    @FXML
    private Label lbl_cli_prenom;
    @FXML
    private Button btn_validate;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_update;
    @FXML
    private Button btn_delete;
    @FXML
    private Button btn_backTable;
    @FXML
    private Label lbl_action;
    @FXML
    private Label lbl_error;
    @FXML
    private Pane pane_tab;
    @FXML
    private Pane pane_TextField;

    ObservableList<Client> model = FXCollections.observableArrayList();
    String action = "";
    Client cli = new Client();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        openTable();
        pane_TextField.setDisable(false);
        txt_cli_id.setDisable(true);
        txt_cli_password.setDisable(true);
        initTab();
    }

    @FXML
    private void btn_add(ActionEvent event) {
        action = "add";
        lbl_action.setText("Ajout d'un client en cours");
        openForm();
    }

    @FXML
    private void btn_update(ActionEvent event) {

        if (tab_clients.getSelectionModel().getSelectedItem() != null) {
            action = "update";
            openForm();
            lbl_action.setText("Mise à jour d'un client en cours");
            cli = tab_clients.getSelectionModel().getSelectedItem();
            completeForm();
        } else {
            lbl_error.setText("essaye en cliquant sur une ligne du tableau...");
        }
    }

    @FXML
    private void btn_delete(ActionEvent event) {

        if (tab_clients.getSelectionModel().getSelectedItem() != null) {
            action = "delete";
            openForm();
            lbl_action.setText("Suppression d'un client en cours");
            pane_TextField.setDisable(true);
            cli = tab_clients.getSelectionModel().getSelectedItem();
            completeForm();
        } else {
            lbl_error.setText("essaye en cliquant sur une ligne du tableau...");
        }
    }

    @FXML
    private void btn_backHome(ActionEvent event) throws IOException {
        App.setRoot("Accueil");
    }

    @FXML
    private void btn_validate(ActionEvent event) {

        try {
            Client c = null;
            if (action == "add") {
                c = new Client();
            } else if (action == "update" || action == "delete") {
                c = tab_clients.getSelectionModel().getSelectedItem();
            }      

            c.setCli_nom(txt_cli_nom.getText());
            c.setCli_prenom(txt_cli_prenom.getText());
            c.setCli_rue(txt_cli_rue.getText());
            c.setCli_code_postal(txt_cli_code_postal.getText());
            c.setCli_ville(txt_cli_ville.getText());
            c.setCli_pays(txt_cli_pays.getText());
            c.setCli_mail(txt_cli_mail.getText());
            c.setCli_password(txt_cli_password.getText());
            c.setCli_telephone(txt_cli_telephone.getText());
            c.setCli_statut(txt_cli_status.getText());
            c.setCli_coefficient(Integer.valueOf(txt_cli_coefficient.getText()));

            ClientDAO repo = new ClientDAO();

            if (action == "add") {
                repo.Insert(c);
            } else if (action == "update") {
                repo.Update(c);
            } else if (action == "delete") {
                repo.Delete(c);
            }
            action = "";
            lbl_action.setText("");

            initTab();
            openTable();
            clearForm();
            pane_TextField.setDisable(false);

        } catch (SQLException ex) {
            lbl_action.setText(ex.getMessage());
        }

    }

    @FXML
    private void btn_cancel(ActionEvent event) {
        if (action == "add") {
            clearForm();
        } else if (action == "update" || action == "delete") {
            cli = tab_clients.getSelectionModel().getSelectedItem();
            completeForm();
        }
    }

    @FXML
    private void btn_backTable(ActionEvent event) {
        action = "";
        openTable();
        pane_TextField.setDisable(false);
        clearForm();
    }

    public void completeForm() {
        txt_cli_id.setText(String.valueOf(cli.getCli_id()));
        txt_cli_nom.setText(cli.getCli_nom());
        txt_cli_prenom.setText(cli.getCli_prenom());
        txt_cli_rue.setText(cli.getCli_rue());
        txt_cli_ville.setText(cli.getCli_ville());
        txt_cli_code_postal.setText(cli.getCli_code_postal());
        txt_cli_pays.setText(cli.getCli_pays());
        txt_cli_mail.setText(cli.getCli_mail());
        txt_cli_password.setText(cli.getCli_password());
        txt_cli_telephone.setText(cli.getCli_telephone());
        txt_cli_status.setText(cli.getCli_statut());
        txt_cli_coefficient.setText(String.valueOf(cli.getCli_coefficient()));
    }

    public void clearForm() {
        txt_cli_id.clear();
        txt_cli_nom.clear();
        txt_cli_prenom.clear();
        txt_cli_rue.clear();
        txt_cli_ville.clear();
        txt_cli_code_postal.clear();
        txt_cli_pays.clear();
        txt_cli_mail.clear();
        txt_cli_password.clear();
        txt_cli_telephone.clear();
        txt_cli_status.clear();
        txt_cli_coefficient.clear();
    }

    public void openForm() {
        pane_form.setVisible(true);
        pane_tab.setVisible(false);
    }

    public void openTable() {
        pane_form.setVisible(false);
        pane_tab.setVisible(true);
    }

    public void initTab(){
        model.clear();

        tabc_prenom.setCellValueFactory(new PropertyValueFactory<>("cli_prenom"));
        tabc_nom.setCellValueFactory(new PropertyValueFactory<>("cli_nom"));
        tabc_ville.setCellValueFactory(new PropertyValueFactory<>("cli_ville"));
        tabc_telephone.setCellValueFactory(new PropertyValueFactory<>("cli_telephone"));

        tab_clients.setItems(model);

        try {
            ClientDAO repo = new ClientDAO();
            model.clear();
            model.addAll(repo.List());
        } catch (Exception e) {
            lbl_error.setText("Erreur lors de l'initialisation du tableau");
            System.out.println(e.getMessage());
        }
    }

}
