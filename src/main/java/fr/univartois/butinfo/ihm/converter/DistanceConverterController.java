/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d'aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d'adéquation
 * à un usage particulier et d'absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d'auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d'un contrat, d'un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d'autres éléments du logiciel.
 *
 * (c) 2022-2025 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm.converter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * La classe DistanceConverterController illustre le fonctionnement du contrôleur associé à une vue.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class DistanceConverterController {

    /**
     * Le label de l'application, où l'on va pouvoir afficher des messages.
     * Cet attribut sera initialisé automatiquement par JavaFX grâce à l'annotation {@link FXML}.

     La modif se fait ici de la question 10
     */

    @FXML
    private TextField metreTextField, piedsTextField, yardTextField, mileTextField;


    private final double pied_en_metres = 0.3048;
    private final double yard_en_metres = 0.9144;
    private final double mile_en_metres = 1609.34;

    @FXML
    private void onMetreConvert() {

        if (metreTextField.getText().isEmpty()) {
            afficherErreur("Veuillez entrer une valeur en mètres !");
        }

        try {
            double metres = Double.parseDouble(metreTextField.getText());


            piedsTextField.setText(String.format("%.2f", metres / pied_en_metres));


            yardTextField.setText(String.format("%.2f", metres / pied_en_metres));


            mileTextField.setText(String.format("%.2f", metres / pied_en_metres));
        } catch (NumberFormatException e) {
            afficherErreur("La valeur entrée n'est pas un nombre valide !");
        }
    }

    @FXML
    private void onPiedsConvert() {
        // onPiedsConvert permet de convertir les pieds en mètres, yards et miles
        if (piedsTextField.getText().isEmpty()) {
            afficherErreur("Veuillez entrer une valeur en pieds !");
        }

        try {

            double pieds = Double.parseDouble(piedsTextField.getText());
            double metrs = pieds * pied_en_metres;


            metreTextField.setText(String.format("%.2f", metrs));
            yardTextField.setText(String.format("%.2f", metrs / yard_en_metres));
            mileTextField.setText(String.format("%.2f", metrs / mile_en_metres));
        } catch (NumberFormatException e) {
            afficherErreur("La valeur entrée n'est pas un nombre valide !");
        }
    }

    @FXML
    private void onYardConvert() {
        // onYardConvert permet de convertir les yards en mètres, pieds et miles
        if (yardTextField.getText().isEmpty()) {
            afficherErreur("Veuillez entrer une valeur en yards !");
        }

        try {

            double yards = Double.parseDouble(yardTextField.getText());
            double metres = yards * yard_en_metres;


            metreTextField.setText(String.format("%.2f", metres));
            piedsTextField.setText(String.format("%.2f", metres /pied_en_metres));
            mileTextField.setText(String.format("%.2f", metres / mile_en_metres));
        } catch (NumberFormatException e) {
            afficherErreur("La valeur entrée n'est pas un nombre valide !");
        }
    }

    @FXML
    private void onMileConvert() {
        // onMileConvert permet de convertir les miles en mètres, pieds et yards
        if (mileTextField.getText().isEmpty()) {
            afficherErreur("Veuillez entrer une valeur en miles !");
        }

        try {

            double miles = Double.parseDouble(mileTextField.getText());
            double metres = miles * mile_en_metres;


            metreTextField.setText(String.format("%.2f", metres));
            piedsTextField.setText(String.format("%.2f", metres / pied_en_metres));
            yardTextField.setText(String.format("%.2f", metres / yard_en_metres));
        } catch (NumberFormatException e) {
            afficherErreur("La valeur entrée n'est pas un nombre valide !");
        }
    }


    private void afficherErreur(String message) {
        // J'affiche l'erreur de saisie lors de la conversion
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}


