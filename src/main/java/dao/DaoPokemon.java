package dao;


import dao.modelos.generationData.Generation;
import dao.modelos.generationNames.Generaciones;
import dao.modelos.generationNames.ResultsItem;
import dao.modelos.pokemons.*;
import dao.modelos.types.Types;
import dao.retrofit.PokeApi;
import dao.utils.ConfigurationSingletonOkhttpClient;
import javafx.scene.image.Image;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPokemon {


    public List<ResultsItem> getGeneraciones() {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<ResultsItem> genNames = null;
        try {
            Response<Generaciones> response = pokeApi.getGeneraciones().execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    genNames = response.body().getResults();
                }


            }
        } catch (IOException e) {
            Logger.getLogger("error al añadir el nombre de las  generaciones").log(Level.INFO, e.getMessage(), e);
        }



        return genNames;
    }

    public List<dao.modelos.generationData.PokemonSpeciesItem> getPokemonsByGeneration(String nameGeneration) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<dao.modelos.generationData.PokemonSpeciesItem> listPokemon = null;
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(nameGeneration).execute();

            if (response.isSuccessful()) {
                if (response.body() != null){
                    listPokemon = response.body().getPokemonSpecies();
                }


            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir los pokemons por generaciones").log(Level.INFO, e.getMessage(), e);
        }

        return listPokemon;
    }

    public String getRegionName(String generationName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        String region = "";
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(generationName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    region = response.body().getMainRegion().getName();
                }

            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir el nombre de las regiones").log(Level.INFO, e.getMessage(), e);
        }

        return region;
    }

    public List<TypesItem> getTypes(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<TypesItem> listTypes = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    listTypes = response.body().getTypes();
                }

            }

        } catch (IOException e) {
            Logger.getLogger("error al pedir los tipos por pokemon").log(Level.INFO, e.getMessage(), e);
        }

        return listTypes;
    }

    public List<AbilitiesItemPokemons> getAbilities(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<AbilitiesItemPokemons> listAbilities = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    listAbilities = response.body().getAbilities();
                }

            }

        } catch (IOException e) {
            Logger.getLogger("Error al hacer la llamada de las habilidades").log(Level.INFO, e.getMessage(), e);
        }

        return listAbilities;
    }

    public List<StatsItem> getStats(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<StatsItem> listStats = null;

        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    listStats = response.body().getStats();
                }

            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los stats de los pokemons").log(Level.INFO, e.getMessage(), e);
        }

        return listStats;
    }

    public List<GameIndicesItem> getGames(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        List<GameIndicesItem> listGames = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    listGames = response.body().getGameIndices();
                }

            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los juegos por pokemon").log(Level.INFO, e.getMessage(), e);
        }

        return listGames;
    }

    public Image getImage(String pokemonName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        Image image = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null){
                    image = new Image(response.body().getSprites().getOther().getOfficialArtwork().getFrontDefault());
                }

            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir la imagen del pokemon").log(Level.INFO, e.getMessage(), e);
        }
        return image;
    }

    public Types getDataTypes(String typeName) {
        PokeApi pokeApi = ConfigurationSingletonOkhttpClient.getInstance().create(PokeApi.class);
        Types type = null;
        try {
            Response<Types> response = pokeApi.getTypes(typeName).execute();
            if (response.isSuccessful()) {
                type = response.body();
            }
        } catch (IOException e) {
            Logger.getLogger("Error al pedir los movimientos por tipo").log(Level.INFO, e.getMessage(), e);
        }

        return type;
    }

}
