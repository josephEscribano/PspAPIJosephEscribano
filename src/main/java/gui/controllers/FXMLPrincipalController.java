package gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPrincipalController implements Initializable {
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private BorderPane root = new BorderPane();

    //Anchorpaners y fxmlloader
    @FXML
    private FXMLLoader fxmlpantalla;

    @FXML
    private AnchorPane pantalla;


    //pantallas

    private FXMLPantallaController pantallanueva;



    public void cargarpantalla(){
        fxmlpantalla = new FXMLLoader();
        try{
            if (pantalla == null){
                pantalla = fxmlpantalla.load(getClass().getResourceAsStream("/fxml/pantalla"));
                pantallanueva = fxmlpantalla.getController();
            }
        }catch (Exception e){
            alert.setContentText("La pantalla no se ha podido cargar");
            alert.showAndWait();
        }
    }

    public void ponerpantallanueva(){
        root.setCenter(pantalla);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarpantalla();
    }
}
