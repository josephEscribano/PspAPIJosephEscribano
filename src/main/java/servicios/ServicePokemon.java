package servicios;

import dao.DaoPokemon;
import dao.modelos.generationNames.ResultsItem;
import dao.modelos.pokemons.AbilitiesItemPokemons;
import dao.modelos.pokemons.GameIndicesItem;
import dao.modelos.pokemons.StatsItem;
import dao.modelos.pokemons.TypesItem;
import dao.modelos.types.MovesItem;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class ServicePokemon {


    public List<ResultsItem> getGeneraciones() {
        DaoPokemon daoPokemon = new DaoPokemon();
        return daoPokemon.getGeneraciones();
    }

    public List<String> getPokemonByGeneration(String generationName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listNamesPokemons = new ArrayList<>();
        List<dao.modelos.generationData.PokemonSpeciesItem> listPokemon = daoPokemon.getPokemonsByGeneration(generationName);
        for (dao.modelos.generationData.PokemonSpeciesItem pk : listPokemon) {
            listNamesPokemons.add(pk.getName());
        }
        return listNamesPokemons;
    }

    public String getRegionName(String generationName) {
        DaoPokemon daoPokemon = new DaoPokemon();

        return daoPokemon.getRegionName(generationName);

    }

    public List<String> getTypes(String pokemonName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listTypesNames = new ArrayList<>();
        List<TypesItem> listTypes = daoPokemon.getTypes(pokemonName);
        for (TypesItem ti : listTypes) {
            listTypesNames.add(ti.getType().getName());
        }
        return listTypesNames;

    }

    public List<String> getAbilities(String pokemonName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listAbilitesNames = new ArrayList<>();
        List<AbilitiesItemPokemons> listAbilities = daoPokemon.getAbilities(pokemonName);
        for (AbilitiesItemPokemons aip : listAbilities) {
            listAbilitesNames.add(aip.getAbility().getName());
        }

        return listAbilitesNames;
    }

    public List<String> getStats(String pokemonName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listStatsNames = new ArrayList<>();
        List<StatsItem> listStats = daoPokemon.getStats(pokemonName);
        for (StatsItem si : listStats) {
            listStatsNames.add(si.toString());
        }

        return listStatsNames;
    }

    public List<String> getGames(String pokemonName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listGamesNmaes = new ArrayList<>();
        List<GameIndicesItem> listGames = daoPokemon.getGames(pokemonName);
        for (GameIndicesItem gin : listGames) {
            listGamesNmaes.add(gin.getVersion().getName());
        }

        return listGamesNmaes;
    }

    public Image getImage(String pokemonName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        return daoPokemon.getImage(pokemonName);
    }

    public List<String> getDataType(String typeName) {
        DaoPokemon daoPokemon = new DaoPokemon();
        List<String> listMovesNames = new ArrayList<>();
        List<MovesItem> listMoves = daoPokemon.getDataTypes(typeName).getMoves();
        for (MovesItem mi : listMoves) {
            listMovesNames.add(mi.getName());
        }

        return listMovesNames;
    }
}
