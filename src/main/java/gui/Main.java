package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage Stage) throws Exception {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/principal.fxml"));
        BorderPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        Stage.setTitle("Tienda productos");
        Stage.setScene(scene);
        Stage.show();
        Stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);

    }


}
