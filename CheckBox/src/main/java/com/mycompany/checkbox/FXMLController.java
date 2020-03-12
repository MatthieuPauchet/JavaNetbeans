/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.checkbox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;

/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class FXMLController implements Initializable {

    @FXML
    private ToggleGroup texte;
    @FXML
    private ToggleGroup fond;
    @FXML
    private ToggleGroup casse;
    @FXML
    private CheckBox couleurFond;
    @FXML
    private CheckBox couleurTexte;
    @FXML
    private CheckBox Casse;
    @FXML
    private Label lbl;
    @FXML
    private TextField txt;
    @FXML
    private TitledPane paneTexte;
    @FXML
    private TitledPane paneFond;
    @FXML
    private TitledPane paneCasse;
    @FXML
    private TitledPane paneCheckBox;
    @FXML
    private RadioButton texteRouge;
    @FXML
    private RadioButton texteBlanc;
    @FXML
    private RadioButton texteNoir;
    @FXML
    private RadioButton fondRouge;
    @FXML
    private RadioButton fondVert;
    @FXML
    private RadioButton fondBleu;
    public String style;
    @FXML
    private RadioButton minuscule;
    @FXML
    private RadioButton majuscule;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    

    @FXML
    private void AfficheTexte(ActionEvent event) {
        String phrase = txt.getText();
        lbl.setText(phrase);
        paneCheckBox.setDisable(txt.getText().isEmpty());
        if (txt.getText().isEmpty()) {
            paneTexte.setDisable(true);
            paneFond.setDisable(true);
            paneCasse.setDisable(true);
            lbl.setStyle("");
        }
    }

    @FXML
    private void addStyle(ActionEvent event) {

        style = "";

        if (couleurFond.isSelected()) {
            paneFond.setDisable(false);
            if (fondRouge.isSelected()) {
                style = "-fx-background-color:red";
            } else if (fondVert.isSelected()) {
                style = "-fx-background-color:green";
            } else if (fondBleu.isSelected()) {
                style = "-fx-background-color:blue";
            }
        } else {
            paneFond.setDisable(true);
        }

        if (couleurTexte.isSelected()) {
            paneTexte.setDisable(false);
            if (texteRouge.isSelected()) {
                style += ";-fx-text-fill: red;";
            } else if (texteBlanc.isSelected()) {
                style += ";-fx-text-fill: white;";
            } else if (texteNoir.isSelected()) {
                style += ";-fx-text-fill: black;";
            }
        } else {
            paneTexte.setDisable(true);
        }

        if (Casse.isSelected()) {
            paneCasse.setDisable(false);
            if (minuscule.isSelected()) {
                lbl.setText(txt.getText().toLowerCase());

            } else if (majuscule.isSelected()) {
                lbl.setText(txt.getText().toUpperCase());
            }
        } else {
            paneCasse.setDisable(true);
            lbl.setText(txt.getText());
        }

        System.out.println(lbl.getText());

        lbl.setStyle(style);
    }

}
