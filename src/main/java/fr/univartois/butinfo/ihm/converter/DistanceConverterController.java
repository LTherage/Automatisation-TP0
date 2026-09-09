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

import java.util.Locale;

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

    @FXML
    private TextField metreTextField, piedsTextField, yardTextField, mileTextField;

    private static final double PIED_EN_METRES = 0.3048;
    private static final double YARD_EN_METRES = 0.9144;
    private static final double MILE_EN_METRES = 1609.34;

    @FXML
    private void onMetreConvert() {
        double metres = parseValue(metreTextField, "mètres");
        if (Double.isNaN(metres)) {
            return;
        }
        afficherConversionDepuisMetres(metres);
    }

    @FXML
    private void onPiedsConvert() {
        double pieds = parseValue(piedsTextField, "pieds");
        if (Double.isNaN(pieds)) {
            return;
        }
        afficherConversionDepuisMetres(pieds * PIED_EN_METRES);
    }

    @FXML
    private void onYardConvert() {
        double yards = parseValue(yardTextField, "yards");
        if (Double.isNaN(yards)) {
            return;
        }
        afficherConversionDepuisMetres(yards * YARD_EN_METRES);
    }

    @FXML
    private void onMileConvert() {
        double miles = parseValue(mileTextField, "miles");
        if (Double.isNaN(miles)) {
            return;
        }
        afficherConversionDepuisMetres(miles * MILE_EN_METRES);
    }

    @FXML
    private void onConvertAll() {
        if (!metreTextField.getText().isBlank()) {
            onMetreConvert();
            return;
        }
        if (!piedsTextField.getText().isBlank()) {
            onPiedsConvert();
            return;
        }
        if (!yardTextField.getText().isBlank()) {
            onYardConvert();
            return;
        }
        if (!mileTextField.getText().isBlank()) {
            onMileConvert();
            return;
        }

        afficherErreur("Veuillez entrer une valeur dans au moins un champ pour convertir.");
    }

    @FXML
    private void onResetFields() {
        metreTextField.clear();
        piedsTextField.clear();
        yardTextField.clear();
        mileTextField.clear();
    }

    private void afficherConversionDepuisMetres(double metres) {
        metreTextField.setText(String.format(Locale.US, "%.2f", metres));
        piedsTextField.setText(String.format(Locale.US, "%.2f", metres / PIED_EN_METRES));
        yardTextField.setText(String.format(Locale.US, "%.2f", metres / YARD_EN_METRES));
        mileTextField.setText(String.format(Locale.US, "%.2f", metres / MILE_EN_METRES));
    }

    private double parseValue(TextField field, String label) {
        if (field.getText() == null || field.getText().isBlank()) {
            afficherErreur("Veuillez entrer une valeur en " + label + " !");
            return Double.NaN;
        }

        try {
            return Double.parseDouble(field.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            afficherErreur("La valeur entrée n'est pas un nombre valide !");
            return Double.NaN;
        }
    }

    private void afficherErreur(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
