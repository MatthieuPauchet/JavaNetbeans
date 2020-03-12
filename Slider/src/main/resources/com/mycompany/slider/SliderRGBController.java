/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slider;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author 80010-58-17
 */
public class SliderRGBController implements Initializable {


    @FXML
    private Label color;
    @FXML
    private Label Red;
    @FXML
    private Label green;
    @FXML
    private Label blue;
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderBlue;
    @FXML
    private Slider sliderGreen;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void changeColor(MouseEvent event) {
    }

}
