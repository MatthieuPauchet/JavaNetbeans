/* ???
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slider;

import static com.mycompany.slider.ConverseIntToHexa.converseInt256ToHexa;
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
    private Label green;
    @FXML
    private Label blue;
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderBlue;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Label red;
    double max = 255;
    double min = 0;
    public int rouge = 0;
    public int bleu = 0;
    public int vert = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        red.setStyle("-fx-background-color: rgb(255,0,0);");
        blue.setStyle("-fx-background-color: rgb(0,0,255);");
        green.setStyle("-fx-background-color: rgb(0,255,0);");
        //définir le min et max de chaque slider
        sliderRed.setMax(max);
        sliderBlue.setMax(max);
        sliderGreen.setMax(max);
        sliderRed.setMin(min);
        sliderBlue.setMin(min);
        sliderGreen.setMin(min);
        color.setStyle("-fx-background-color: rgb(" + rouge + "," + vert + "," + bleu + ");");
    }

    @FXML
    private void changeColor(MouseEvent event) {
        
        rouge = (int) sliderRed.getValue();
        bleu = (int) sliderBlue.getValue();
        vert = (int) sliderGreen.getValue();
        String style = "-fx-background-color: rgb(" + rouge + "," + vert + "," + bleu + ");";

        // expression ternaire permettant de définir une couleur opposée au fond avec +/-123
        int rouge2 = rouge > 122 ? rouge - 123 : rouge + 123;
        int vert2 = vert > 122 ? vert - 123 : vert + 123;
        int bleu2 = bleu > 122 ? bleu - 123 : bleu + 123;

        style += ";-fx-text-fill: rgb(" + rouge2 + "," + vert2 + "," + bleu2 + ");";

        color.setStyle(style);

             
        String R = converseInt256ToHexa(rouge);
        String V = converseInt256ToHexa(vert);
        String B = converseInt256ToHexa(bleu);
        String R2 = converseInt256ToHexa(rouge2);
        String V2 = converseInt256ToHexa(vert2);
        String B2 = converseInt256ToHexa(bleu2);

        color.setText("-fx-background-color: rgb(" + rouge + "," + vert + "," + bleu + ")"
                    + "\n Hexa pour Mo : "+R+V+B+""
                    + "\n -fx-text-fill: rgb(" + rouge2 + "," + vert2 + "," + bleu2 + ")"
                    +"\n Hexa pour Mo : "+R2+V2+B2 );
    }   
}

