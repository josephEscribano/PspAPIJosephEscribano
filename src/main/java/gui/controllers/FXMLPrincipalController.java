package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import utils.Constantes;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPrincipalController implements Initializable {
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private BorderPane root = new BorderPane();

    //Anchorpaners y fxmlloader
    @FXML
    private final FXMLLoader fxmlpantalla;

    private AnchorPane pantalla;
    private FXMLPantallaController pantallaController;

    @Inject
    public FXMLPrincipalController(FXMLLoader fxmlpantalla) {
        this.fxmlpantalla = fxmlpantalla;

    }

    public BorderPane getPrincipal() {
        return root;
    }

    public void chargeScreen() {
        try {
            if (pantalla == null) {
                pantalla = fxmlpantalla.load(getClass().getResourceAsStream("/fxml/Pantalla.fxml"));
                pantallaController = fxmlpantalla.getController();
                pantallaController.setPrincipalController(this);
            }
        } catch (Exception e) {
            alert.setContentText(Constantes.FALLO_PANTALLA);
            alert.showAndWait();
        }
        root.setCenter(pantalla);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chargeScreen();
    }
}
