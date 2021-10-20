package gui.controllers;

import dao.modelos.generationNames.ResultsItem;
import javafx.event.ActionEvent;
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
    private ListView<String> lvMoves;
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
    public void search(){
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
        ServicePokemon servicePokemon = new ServicePokemon();
        for (ResultsItem rt : servicePokemon.getGeneraciones()) {
            cbGeneration.getItems().add(rt.getName());
        }

    }

    //Cada vez que se cambia de generación se muestra la region que corresponde a esa generación en el label
    public void chargePokemonByGeneration() {
        ServicePokemon servicePokemon = new ServicePokemon();
        String generation = cbGeneration.getSelectionModel().getSelectedItem();
        if (generation != null) {
            lvRegion.getItems().setAll(servicePokemon.getPokemonByGeneration(generation));
            lRegion.setText(servicePokemon.getRegionName(generation));
        } else {
            alert.setContentText("error al cargar los pokemons");
            alert.showAndWait();
        }
    }

    //Cuando hablo de cargar juegos, me refiero a los juegos en los que  aparece el pokemon seleccionado.
    public void chargePokemonData() {
        ServicePokemon servicePokemon = new ServicePokemon();
        String pokemon = lvRegion.getSelectionModel().getSelectedItem();
        if (pokemon != null) {
            lvTypes.getItems().setAll(servicePokemon.getTypes(pokemon));
            lvAbilities.getItems().setAll(servicePokemon.getAbilities(pokemon));
            lvStats.getItems().setAll(servicePokemon.getStats(pokemon));
            imPokemon.setImage(servicePokemon.getImage(pokemon));
            lvGames.getItems().setAll(servicePokemon.getGames(pokemon));
        } else {
            alert.setContentText("Selecciona un pokemon");
            alert.showAndWait();
        }
    }

    public void chargeMovesByType() {
        ServicePokemon servicePokemon = new ServicePokemon();
        String type = lvTypes.getSelectionModel().getSelectedItem();
        if (type != null) {
            lvMoves.getItems().setAll(servicePokemon.getDataType(type));
        } else {
            alert.setContentText("Selecciona un tipo");
            alert.showAndWait();
        }
    }
}
