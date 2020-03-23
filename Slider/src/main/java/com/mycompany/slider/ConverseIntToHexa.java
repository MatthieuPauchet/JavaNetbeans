/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slider;

/**
 *
 * @author M.Pauchet 01/02/2020
 * Méthode permettant de convertir un int inférieur à 256 en Hexa pour les codes couleurs notamment
 */
public class ConverseIntToHexa {
    public static String converseInt256ToHexa(int number) {

        int x = number / 16;
        int y = number % 16;
        String X = converseInt16ToHexa(x);
        String Y = converseInt16ToHexa(y);

        return X + Y;
    }

    public static String converseInt16ToHexa(int number) {

        String X = "";

        switch (number) {
            case 15:
                X = "F";
                break;
            case 14:
                X = "E";
                break;
            case 13:
                X = "D";
                break;
            case 12:
                X = "C";
                break;
            case 11:
                X = "B";
                break;
            case 10:
                X = "A";
                break;
            default:
                X = "" + number;
                break;
        }

        return X;
    }
}
