package gui.controllers;

import dao.modelos.generationNames.ResultsItem;
import io.vavr.control.Either;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import servicios.ServicePokemon;
import utils.Constantes;

import javax.inject.Inject;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FXMLPantallaController implements Initializable {

    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private FXMLPrincipalController principalController;

    @Inject
    private ServicePokemon servicePokemon;
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


    public void setPrincipalController(FXMLPrincipalController principal) {
        this.principalController = principal;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chargeImage();
        chargeNamesGenerations();
    }

    public void chargeImage() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(Constantes.RUTA_IMAGEN)));
        imPokemonTitulo.setImage(image);

    }

    public void search() {
        boolean encontrado = true;
        if (!lvRegion.getItems().isEmpty()) {
            if (tfBuscador.getText().isEmpty()) {
                alert.setContentText(Constantes.CAMPO_VACIO);
                alert.showAndWait();
            } else {
                for (String s : lvRegion.getItems()) {
                    if (s.equals(tfBuscador.getText().toLowerCase())) {
                        encontrado = false;
                        lvRegion.scrollTo(tfBuscador.getText().toLowerCase());
                    }
                }
                if (encontrado) {
                    alert.setContentText(Constantes.POKEMON_NO_ENCONTRADO);
                    alert.showAndWait();
                }
            }
        } else {
            alert.setContentText(Constantes.SELECCIONA_GENERACION);
            alert.showAndWait();
        }
    }

    //selecciona una generacion para poder ver los pokemons de esa generacion
    public void chargeNamesGenerations() {
        var tarea = new Task<Either<String, List<ResultsItem>>>() {
            @Override
            protected Either<String, List<ResultsItem>> call() throws Exception {
                return servicePokemon.getGeneraciones();
            }
        };

        tarea.setOnSucceeded(workerStateEvent -> {
            tarea.getValue().peek(generation -> cbGeneration.getItems().addAll(generation.stream().map(ResultsItem::getName).collect(Collectors.toList())))
                    .peekLeft(error -> {
                        alert.setContentText(error);
                        alert.showAndWait();
                    });
            this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
        });

        tarea.setOnFailed(workerStateEvent -> {
            alert.setContentText(workerStateEvent.getSource().getException().getMessage());
            alert.showAndWait();
            this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
        });
        new Thread(tarea).start();

    }

    //Cada vez que se cambia de generación se muestra la region que corresponde a esa generación en el label
    public void chargePokemonByGeneration() {
        String generation = cbGeneration.getSelectionModel().getSelectedItem();
        if (generation != null) {
            var tarea = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {

                    return servicePokemon.getPokemonByGeneration(generation);
                }
            };

            //tarea
            tarea.setOnSucceeded(workerStateEvent -> {
                tarea.getValue().peek(p -> lvRegion.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });


            tarea.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tarea).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);

            //TareaRegion
            var tareaRegion = new Task<Either<String, String>>() {
                @Override
                protected Either<String, String> call() throws Exception {
                    return servicePokemon.getRegionName(generation);
                }
            };

            tareaRegion.setOnSucceeded(workerStateEvent -> {
                tareaRegion.getValue().peek(r -> lRegion.setText(r))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaRegion.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaRegion).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);
        } else {
            alert.setContentText(Constantes.SELECCIONA_GENERACION);
            alert.showAndWait();
        }
    }

    //Cuando hablo de cargar juegos, me refiero a los juegos en los que  aparece el pokemon seleccionado.
    public void chargePokemonData() {
        String pokemon = lvRegion.getSelectionModel().getSelectedItem();
        if (pokemon != null) {
            var tareaTypes = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {
                    return servicePokemon.getTypes(pokemon);
                }
            };
            //TareaTypes

            tareaTypes.setOnSucceeded(workerStateEvent -> {
                tareaTypes.getValue().peek(p -> lvTypes.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaTypes.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaTypes).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);

            //TareaAbilities

            var tareaAbilities = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {
                    return servicePokemon.getAbilities(pokemon);
                }
            };

            tareaAbilities.setOnSucceeded(workerStateEvent -> {
                tareaAbilities.getValue().peek(p -> lvAbilities.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaAbilities.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaAbilities).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);

            //TareaStats
            var tareaStats = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {
                    return servicePokemon.getStats(pokemon);
                }
            };

            tareaStats.setOnSucceeded(workerStateEvent -> {
                tareaStats.getValue().peek(p -> lvStats.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaStats.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaStats).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);


            //TareaImage

            var tareaImage = new Task<Either<String, Image>>() {
                @Override
                protected Either<String, Image> call() throws Exception {
                    return servicePokemon.getImage(pokemon);
                }
            };

            tareaImage.setOnSucceeded(workerStateEvent -> {
                tareaImage.getValue().peek(p -> imPokemon.setImage(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaImage.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            new Thread(tareaImage).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);

            //TareaGames

            var tareaGames = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {
                    return servicePokemon.getGames(pokemon);
                }
            };

            tareaGames.setOnSucceeded(workerStateEvent -> {
                tareaGames.getValue().peek(p -> lvGames.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);

            });

            tareaGames.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaGames).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);
        } else {
            alert.setContentText(Constantes.SELECCIONA_POKEMON);
            alert.showAndWait();
        }
    }

    public void chargeMovesByType() {
        String type = lvTypes.getSelectionModel().getSelectedItem();
        if (type != null) {
            var tareaTipo = new Task<Either<String, List<String>>>() {
                @Override
                protected Either<String, List<String>> call() throws Exception {
                    return servicePokemon.getDataType(type);
                }
            };

            tareaTipo.setOnSucceeded(workerStateEvent -> {
                tareaTipo.getValue().peek(p -> lvMoves.getItems().setAll(p))
                        .peekLeft(error -> {
                            alert.setContentText(error);
                            alert.showAndWait();
                        });
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });

            tareaTipo.setOnFailed(workerStateEvent -> {
                alert.setContentText(workerStateEvent.getSource().getException().getMessage());
                alert.showAndWait();
                this.principalController.getPrincipal().setCursor(Cursor.DEFAULT);
            });
            new Thread(tareaTipo).start();
            this.principalController.getPrincipal().setCursor(Cursor.WAIT);
        } else {
            alert.setContentText(Constantes.SELECCIONA_TIPO);
            alert.showAndWait();
        }
    }
}
