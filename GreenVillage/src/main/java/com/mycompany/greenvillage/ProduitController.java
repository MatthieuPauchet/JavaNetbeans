/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.greenvillage;

import DAL.Client;
import DAL.ClientDAO;
import DAL.Fournisseur;
import DAL.FournisseurDAO;
import DAL.Produit;
import DAL.ProduitDAO;
import DAL.Rubrique;
import DAL.RubriqueDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class ProduitController implements Initializable {

    @FXML
    private AnchorPane pane_produits;
    @FXML
    private Pane pane_tab;
    @FXML
    private Pane pane_form;
    @FXML
    private Pane pane_textField;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_fournisseur;
    @FXML
    private TextField txt_rubrique;
    @FXML
    private TextField txt_prix;
    @FXML
    private TextField txt_libCourt;
    @FXML
    private TextArea txt_libLong;
    @FXML
    private ImageView picture;
    @FXML
    private Label lbl_id;
    @FXML
    private Label lbl_id1;
    @FXML
    private Label lbl_id2;
    @FXML
    private Label lbl_id21;
    @FXML
    private Label lbl_id22;
    @FXML
    private Label lbl_id23;
    @FXML
    private Label lbl_id24;
    @FXML
    private TableView<Produit> tab_produits;
    @FXML
    private TableColumn<Produit, String> tabc_libCourt;
    @FXML
    private TableColumn<Produit, Double> tabc_prix;
    @FXML
    private TableColumn<Produit, Integer> tabc_rubrique;
    @FXML
    private TableColumn<Produit, Integer> tabc_fournisseur;
    @FXML
    private Label lbl_error;
    @FXML
    private TextField txt_photo;
    @FXML
    private Label lbl_action;
    @FXML
    private ComboBox<String> combo_rub;
    @FXML
    private ComboBox<String> combo_fou;

    ObservableList<Produit> model = FXCollections.observableArrayList();
    String action = "";
    Produit pro = new Produit();
    Rubrique sRub = new Rubrique();
    Fournisseur fou = new Fournisseur();
    List<Rubrique> liste;
    List<Fournisseur> listeFou;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        openTable();
        txt_id.setDisable(true);
        initTab();

        try {
            RubriqueDAO rubDAO = new RubriqueDAO();
            liste = rubDAO.ListSsRub();
            for (int i = 0; i < liste.size(); i++) {
                combo_rub.getItems().add(liste.get(i).getNom());
            }

            FournisseurDAO fouDAO = new FournisseurDAO();
            listeFou = fouDAO.List();
            for (int i = 0; i < listeFou.size(); i++) {
                combo_fou.getItems().add(listeFou.get(i).getNom());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void btn_backHome(ActionEvent event) throws IOException {
        App.setRoot("Accueil");
    }

    @FXML
    private void btn_update(ActionEvent event) {
        if (tab_produits.getSelectionModel().getSelectedItem() != null) {
            action = "update";
            openForm();
            lbl_action.setText("Mise à jour d'un produit en cours");
            completeForm();
        } else {
            lbl_error.setText("essaye en cliquant sur une ligne du tableau...");
        }
    }

    @FXML
    private void btn_delete(ActionEvent event) {
        if (tab_produits.getSelectionModel().getSelectedItem() != null) {
            action = "delete";
            openForm();
            lbl_action.setText("Suppression d'un client en cours");
            pane_textField.setDisable(true);
            completeForm();
        } else {
            lbl_error.setText("essaye en cliquant sur une ligne du tableau...");
        }
    }

    @FXML
    private void btn_add(ActionEvent event) {
        action = "add";
        lbl_action.setText("Ajout d'un produit en cours" + liste.get(0).getNom());
        openForm();
        combo_rub.setValue(liste.get(0).getNom());
        combo_fou.setValue(listeFou.get(0).getNom());
    }

    @FXML
    private void btn_validate(ActionEvent event) {
        try {
            pro = null;
            if (action == "add") {
                pro = new Produit();
            } else if (action == "update" || action == "delete") {
                pro = tab_produits.getSelectionModel().getSelectedItem();
            }

            pro.setLibCourt(txt_libCourt.getText());
            pro.setLibLong(txt_libLong.getText());
            pro.setPhoto(txt_photo.getText());
            pro.setRubId(Integer.valueOf(txt_rubrique.getText()));
            pro.setFouId(Integer.valueOf(txt_fournisseur.getText()));
            pro.setPrixAchat(Double.valueOf(txt_prix.getText()));

            ProduitDAO repo = new ProduitDAO();

            if (action == "add") {
                repo.Insert(pro);
            } else if (action == "update") {
                repo.Update(pro);
            } else if (action == "delete") {
                repo.Delete(pro);
            }
            action = "";
            lbl_action.setText("");

            initTab();
            openTable();
            clearForm();
            pane_textField.setDisable(false);

            FournisseurDAO fouDAO = new FournisseurDAO();
            Fournisseur test = fouDAO.FindByName(combo_fou.getValue());
        } catch (SQLException ex) {
            lbl_action.setText(ex.getMessage());
        }
    }

    @FXML
    private void btn_backTab(ActionEvent event) {
        action = "";
        openTable();
        pane_textField.setDisable(false);
        clearForm();
    }

    @FXML
    private void btn_cancel(ActionEvent event) {
        if (action == "add") {
            clearForm();
        } else if (action == "update" || action == "delete") {
            completeForm();
        }

    }

    @FXML
    private void combo_rub(ActionEvent event) {

        try {
            RubriqueDAO rubDAO = new RubriqueDAO();
            Rubrique rub = rubDAO.FindByName(combo_rub.getValue());
            txt_rubrique.setText(String.valueOf(rub.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void combo_fou(ActionEvent event) {
        try {
            FournisseurDAO fouDAO = new FournisseurDAO();
            Fournisseur fou = fouDAO.FindByName(combo_fou.getValue());
            txt_fournisseur.setText(String.valueOf(fou.getId()));
        } catch (SQLException ex) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openForm() {
        pane_form.setVisible(true);
        pane_tab.setVisible(false);
    }

    public void openTable() {
        pane_form.setVisible(false);
        pane_tab.setVisible(true);
    }

    public void initTab() {
        model.clear();

        tabc_libCourt.setCellValueFactory(new PropertyValueFactory<>("libCourt"));
        tabc_prix.setCellValueFactory(new PropertyValueFactory<>("prixAchat"));
        tabc_rubrique.setCellValueFactory(new PropertyValueFactory<>("rubId"));
        tabc_fournisseur.setCellValueFactory(new PropertyValueFactory<>("fouId"));

        tab_produits.setItems(model);

        try {
            ProduitDAO repo = new ProduitDAO();
            model.clear();
            model.addAll(repo.List());
        } catch (Exception e) {
            lbl_error.setText(e.getMessage());
        }
    }

    public void completeForm() {
        pro = tab_produits.getSelectionModel().getSelectedItem();

        txt_id.setText(String.valueOf(pro.getId()));
        txt_libCourt.setText(pro.getLibCourt());
        txt_libLong.setText(pro.getLibLong());
        txt_photo.setText(pro.getPhoto());
        txt_rubrique.setText(String.valueOf(pro.getRubId()));
        txt_fournisseur.setText(String.valueOf(pro.getFouId()));
        txt_prix.setText(String.valueOf(pro.getPrixAchat()));
        selectComboRub();
        selectComboFou();
    }

    public void clearForm() {
        txt_id.clear();
        txt_libCourt.clear();
        txt_libLong.clear();
        txt_photo.clear();
        txt_rubrique.clear();
        txt_fournisseur.clear();
        txt_prix.clear();
    }

    public void selectComboFou() {
        FournisseurDAO fouDAO;
        try {
            fouDAO = new FournisseurDAO();
            Fournisseur fou = fouDAO.FindById(Integer.valueOf(txt_fournisseur.getText()));
            combo_fou.setValue(fou.getNom());
        } catch (SQLException ex) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void selectComboRub() {
        try {
            RubriqueDAO rubDAO = new RubriqueDAO();
            Rubrique rub = rubDAO.FindById(Integer.valueOf(txt_rubrique.getText()));
            combo_rub.setValue(rub.getNom());
        } catch (SQLException ex) {
            Logger.getLogger(ProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
