package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage Stage) throws Exception {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/Principal.fxml"));
        BorderPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        Stage.setTitle("Pokedex");
        Stage.setScene(scene);
        Stage.show();
        Stage.setResizable(false);
    }


}
