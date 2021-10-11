package gui.controllers;

import dao.modelos.generationNames.ResultsItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import servicios.ServicePokemon;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPantallaController implements Initializable {

    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ImageView imPokemonTitulo;
    @FXML
    private TextField tfBuscador;

    @FXML
    private ImageView imPokemon;
    @FXML
    private ListView<String> lvRegion;
    @FXML
    private ComboBox<String> cbGeneration;
    @FXML
    private Label lRegion;
    @FXML
    private ListView<String> lvTypes;
    @FXML
    private ListView<String> lvAbilities;
    @FXML
    private ListView<String> lvStats;
    @FXML
    private ListView<String> lvGames;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chargeImage();
        chargeNamesGenerations();
    }

    public void chargeImage(){
        Image image = new Image(getClass().getResourceAsStream("/images/PokemonTitulo.png"));
        imPokemonTitulo.setImage(image);

    }
    public void Search(){
        boolean encontrado = true;
        if (!lvRegion.getItems().isEmpty()){
            for (String s:lvRegion.getItems()) {
                if (s.equals(tfBuscador.getText().toLowerCase())){
                    encontrado = false;
                    lvRegion.scrollTo(tfBuscador.getText().toLowerCase());
                }
            }
            if (encontrado){
                alert.setContentText("El pokemon que buscas no esta en esta generación");
                alert.showAndWait();
            }
        }else{
            alert.setContentText("Necesitas elegir una generación");
            alert.showAndWait();
        }
    }
    //selecciona una generacion para poder ver los pokemons de esa generacion
    public void chargeNamesGenerations() {
        ServicePokemon sp = new ServicePokemon();
        for (ResultsItem rt : sp.getGeneraciones()) {
            cbGeneration.getItems().add(rt.getName());
        }

    }

    //Cada vez que se cambia de generación se muestra la region que corresponde a esa generación en el label
    public void chargePokemonByGeneration() {
        ServicePokemon sp = new ServicePokemon();
        String generation = cbGeneration.getSelectionModel().getSelectedItem();
        if (generation != null) {
            lvRegion.getItems().setAll(sp.getPokemonByGeneration(generation));
            lRegion.setText(sp.getRegionName(generation));
        } else {
            alert.setContentText("error al cargar los pokemons");
            alert.showAndWait();
        }
    }

    //Cuando hablo de cargar juegos, me refiero a los juegos en los que  aparece el pokemon seleccionado.
    public void chargePokemonData() {
        ServicePokemon sp = new ServicePokemon();
        String pokemon = lvRegion.getSelectionModel().getSelectedItem();
        if (pokemon != null) {
            lvTypes.getItems().setAll(sp.getTypes(pokemon));
            lvAbilities.getItems().setAll(sp.getAbilities(pokemon));
            lvStats.getItems().setAll(sp.getStats(pokemon));
            imPokemon.setImage(sp.getImage(pokemon));
            lvGames.getItems().setAll(sp.getGames(pokemon));
        } else {
            alert.setContentText("Selecciona un pokemon");
            alert.showAndWait();
        }
    }

    public void chargeScreenTypes() {

        FXMLLoader fxmlPantallaTipos = new FXMLLoader();
        AnchorPane pantallaTipos;
        FXMLPantallaTipos pantallaTiposController;
        String type = lvTypes.getSelectionModel().getSelectedItem();
        try {
            if(type != null){
                pantallaTipos = fxmlPantallaTipos.load(getClass().getResourceAsStream("/fxml/PantallaTipos.fxml"));
                pantallaTiposController = fxmlPantallaTipos.getController();
                pantallaTiposController.chargeMovesByType(type);

                Stage stage = new Stage();
                stage.setScene(new Scene(pantallaTipos));
                stage.show();
            }else{
                alert.setContentText("Debes seleccionar un tipo");
                alert.showAndWait();
            }
        } catch (IOException e) {
            alert.setContentText("No se ha podido cargar la pantalla de tipos");
            alert.showAndWait();
        }

    }


}
