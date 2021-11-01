package servicios;

import dao.DaoPokemon;
import dao.modelos.generationNames.ResultsItem;
import dao.modelos.pokemons.AbilitiesItemPokemons;
import dao.modelos.pokemons.GameIndicesItem;
import dao.modelos.pokemons.StatsItem;
import dao.modelos.pokemons.TypesItem;
import dao.modelos.types.MovesItem;
import io.vavr.control.Either;
import javafx.scene.image.Image;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ServicePokemon {

    private final DaoPokemon daoPokemon;

    @Inject
    public ServicePokemon(DaoPokemon daoPokemon) {
        this.daoPokemon = daoPokemon;
    }

    public Either<String, List<ResultsItem>> getGeneraciones() {
        return daoPokemon.getGeneraciones();
    }

    public Either<String, List<String>> getPokemonByGeneration(String generationName) {
        Either<String, List<String>> listnames;
        if (daoPokemon.getPokemonsByGeneration(generationName).isRight()) {
            List<String> listNamesPokemons = new ArrayList<>();
            List<dao.modelos.generationData.PokemonSpeciesItem> listPokemon = daoPokemon.getPokemonsByGeneration(generationName).get();
            for (dao.modelos.generationData.PokemonSpeciesItem pk : listPokemon) {
                listNamesPokemons.add(pk.getName());
            }

            listnames = Either.right(listNamesPokemons);
        } else {
            listnames = Either.left(daoPokemon.getPokemonsByGeneration(generationName).getLeft());
        }


        return listnames;
    }

    public Either<String, String> getRegionName(String generationName) {
        return daoPokemon.getRegionName(generationName);
    }

    public Either<String, List<String>> getTypes(String pokemonName) {
        Either<String, List<String>> listNames;
        if (daoPokemon.getTypes(pokemonName).isRight()) {
            List<String> listTypesNames = new ArrayList<>();
            List<TypesItem> listTypes = daoPokemon.getTypes(pokemonName).get();
            for (TypesItem ti : listTypes) {
                listTypesNames.add(ti.getType().getName());
            }
            listNames = Either.right(listTypesNames);
        } else {
            listNames = Either.left(daoPokemon.getTypes(pokemonName).getLeft());
        }

        return listNames;

    }

    public Either<String, List<String>> getAbilities(String pokemonName) {
        Either<String, List<String>> listNames;
        if (daoPokemon.getAbilities(pokemonName).isRight()) {
            List<String> listAbilitesNames = new ArrayList<>();
            List<AbilitiesItemPokemons> listAbilities = daoPokemon.getAbilities(pokemonName).get();
            for (AbilitiesItemPokemons aip : listAbilities) {
                listAbilitesNames.add(aip.getAbility().getName());
            }
            listNames = Either.right(listAbilitesNames);
        } else {
            listNames = Either.left(daoPokemon.getAbilities(pokemonName).getLeft());
        }


        return listNames;
    }

    public Either<String, List<String>> getStats(String pokemonName) {
        Either<String, List<String>> listNames;
        if (daoPokemon.getStats(pokemonName).isRight()) {
            List<String> listStatsNames = new ArrayList<>();
            List<StatsItem> listStats = daoPokemon.getStats(pokemonName).get();
            for (StatsItem si : listStats) {
                listStatsNames.add(si.toString());
            }
            listNames = Either.right(listStatsNames);
        } else {
            listNames = Either.left(daoPokemon.getStats(pokemonName).getLeft());
        }


        return listNames;
    }

    public Either<String, List<String>> getGames(String pokemonName) {
        Either<String, List<String>> listNames;
        if (daoPokemon.getGames(pokemonName).isRight()) {
            List<String> listGamesNmaes = new ArrayList<>();
            List<GameIndicesItem> listGames = daoPokemon.getGames(pokemonName).get();
            for (GameIndicesItem gin : listGames) {
                listGamesNmaes.add(gin.getVersion().getName());
            }
            listNames = Either.right(listGamesNmaes);
        } else {
            listNames = Either.left(daoPokemon.getGames(pokemonName).getLeft());
        }


        return listNames;
    }

    public Either<String, Image> getImage(String pokemonName) {
        return daoPokemon.getImage(pokemonName);
    }

    public Either<String, List<String>> getDataType(String typeName) {
        Either<String, List<String>> listNames;
        if (daoPokemon.getDataTypes(typeName).isRight()) {
            List<String> listMovesNames = new ArrayList<>();
            List<MovesItem> listMoves = daoPokemon.getDataTypes(typeName).get();
            for (MovesItem mi : listMoves) {
                listMovesNames.add(mi.getName());
            }
            listNames = Either.right(listMovesNames);
        } else {
            listNames = Either.left(daoPokemon.getDataTypes(typeName).getLeft());
        }


        return listNames;
    }
}
