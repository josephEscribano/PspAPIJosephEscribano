package dao;


import dao.modelos.generationData.Generation;
import dao.modelos.generationNames.Generaciones;
import dao.modelos.generationNames.ResultsItem;
import dao.modelos.pokemons.*;
import dao.modelos.types.Types;
import dao.retrofit.PokeApi;
import dao.utils.ConfigurationSingleton_OkhttpClient;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPokemon {
    private final Alert alert = new Alert(Alert.AlertType.ERROR);

    public List<ResultsItem> getGeneraciones() {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<ResultsItem> genNames = new ArrayList<>();
        try {
            Response<Generaciones> response = pokeApi.getGeneraciones().execute();

            if (response.isSuccessful()) {
                genNames = response.body().getResults();

            } else {
                alert.setContentText("Error" + response.code() + " en la llamada al obtener el nombre de las generaciones");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Logger.getLogger("error al añadir el nombre de las  generaciones").log(Level.INFO, e.getMessage(), e);
        }


        return genNames;
    }

    public List<dao.modelos.generationData.PokemonSpeciesItem> getPokemonsByGeneration(String nameGeneration) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<dao.modelos.generationData.PokemonSpeciesItem> lp = new ArrayList<>();
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(nameGeneration).execute();

            if (response.isSuccessful()) {
                lp = response.body().getPokemonSpecies();

            } else {
                alert.setContentText("Error" + response.code() + "en la llamada al obtener los pokemons por generacion");
                alert.showAndWait();
            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir los pokemons por generaciones").log(Level.INFO, e.getMessage(), e);
        }

        return lp;
    }

    public String getRegionName(String GenerationName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        String region = "";
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(GenerationName).execute();
            if (response.isSuccessful()) {
                region = response.body().getMainRegion().getName();
            } else {
                alert.setContentText("Error" + response.code() + " en la llamada al obtener el nombre de la region");
                alert.showAndWait();
            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir el nombre de las regiones").log(Level.INFO, e.getMessage(), e);
        }

        return region;
    }

    public List<TypesItem> getTypes(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<TypesItem> pt = new ArrayList<>();
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                pt = response.body().getTypes();
            } else {
                alert.setContentText("Error" + response.code() + "en la llamada a los tipos del pokemon");
                alert.showAndWait();
            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir los tipos por pokemon").log(Level.INFO, e.getMessage(), e);
        }

        return pt;
    }

    public List<AbilitiesItemPokemons> getAbilities(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<AbilitiesItemPokemons> ab = new ArrayList<>();
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                ab = response.body().getAbilities();
            } else {
                alert.setContentText("Error" + response.code() + "al hacer la llamada para obtener las habilidades de los pokemons");
                alert.showAndWait();
            }

        } catch (IOException e) {
            Logger.getLogger("Error al hacer la llamada de las habilidades").log(Level.INFO, e.getMessage(), e);
        }

        return ab;
    }

    public List<StatsItem> getStats(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<StatsItem> lsi = new ArrayList<>();

        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                lsi = response.body().getStats();
            } else {
                alert.setContentText("Error " + response.code() + " al hacer la llamada para obtener los stats ");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los stats de los pokemons").log(Level.INFO, e.getMessage(), e);
        }

        return lsi;
    }

    public List<GameIndicesItem> getGames(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        List<GameIndicesItem> gi = new ArrayList<>();
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                gi = response.body().getGameIndices();
            } else {
                alert.setContentText("Error" + response.code() + "al hacer la llamada para obtener los juegos en los que aparece el pokemon");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los juegos por pokemon").log(Level.INFO, e.getMessage(), e);
        }

        return gi;
    }

    public Image getImage(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        Image image = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                image = new Image(response.body().getSprites().getFrontDefault());
            } else {
                alert.setContentText("Error" + response.code() + "al hacer la llamada para obtener la imagen");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir la imagen del pokemon").log(Level.INFO, e.getMessage(), e);
        }
        return image;
    }

    public Types getDataTypes(String typeName) {
        PokeApi pokeApi = ConfigurationSingleton_OkhttpClient.getInstance().create(PokeApi.class);
        Types ty = null;
        try {
            Response<Types> response = pokeApi.getTypes(typeName).execute();
            if (response.isSuccessful()) {
                ty = response.body();
            } else {
                alert.setContentText("Error" + response.code() + "al hacer la llamada para obtener los movimientos por tipo");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los movimientos por tipo").log(Level.INFO, e.getMessage(), e);
        }

        return ty;
    }

}
