package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPrincipalController implements Initializable {
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private BorderPane root = new BorderPane();

    //Anchorpaners y fxmlloader
    @FXML
    private FXMLLoader fxmlpantalla;
    @FXML
    private AnchorPane pantalla;


    public void chargeScreen() {
        fxmlpantalla = new FXMLLoader();
        try {
            if (pantalla == null) {
                pantalla = fxmlpantalla.load(getClass().getResourceAsStream("/fxml/Pantalla.fxml"));

            }
        } catch (Exception e) {
            alert.setContentText("La pantalla no se ha podido cargar");
            alert.showAndWait();
        }
        root.setCenter(pantalla);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chargeScreen();
    }
}
