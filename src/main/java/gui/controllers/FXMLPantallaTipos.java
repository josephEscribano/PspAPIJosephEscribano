package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import servicios.ServicePokemon;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPantallaTipos implements Initializable {
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ListView<String> lvMoves;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void chargeMovesByType(String typeName) {
        ServicePokemon servicePokemon = new ServicePokemon();
        if (typeName != null) {
            lvMoves.getItems().setAll(servicePokemon.getDataType(typeName));
        } else {
            alert.setContentText("Selecciona un tipo");
            alert.showAndWait();
        }
    }
}
