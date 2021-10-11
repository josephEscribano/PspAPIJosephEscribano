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
        DaoPokemon dg = new DaoPokemon();
        return dg.getGeneraciones();
    }

    public List<String> getPokemonByGeneration(String generationName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> ls = new ArrayList<>();
        List<dao.modelos.generationData.PokemonSpeciesItem> lp = dg.getPokemonsByGeneration(generationName);
        for (dao.modelos.generationData.PokemonSpeciesItem pk : lp) {
            ls.add(pk.getName());
        }
        return ls;
    }

    public String getRegionName(String generationName) {
        DaoPokemon dg = new DaoPokemon();

        return dg.getRegionName(generationName);

    }

    public List<String> getTypes(String pokemonName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> ls = new ArrayList<>();
        List<TypesItem> lt = dg.getTypes(pokemonName);
        for (TypesItem ti : lt) {
            ls.add(ti.getType().getName());
        }
        return ls;

    }

    public List<String> getAbilities(String pokemonName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> ls = new ArrayList<>();
        List<AbilitiesItemPokemons> ap = dg.getAbilities(pokemonName);
        for (AbilitiesItemPokemons aip : ap) {
            ls.add(aip.getAbility().getName());
        }

        return ls;
    }

    public List<String> getStats(String pokemonName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> ls = new ArrayList<>();
        List<StatsItem> lsi = dg.getStats(pokemonName);
        for (StatsItem si : lsi) {
            ls.add(si.toString());
        }

        return ls;
    }

    public List<String> getGames(String pokemonName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> ls = new ArrayList<>();
        List<GameIndicesItem> gi = dg.getGames(pokemonName);
        for (GameIndicesItem gin : gi) {
            ls.add(gin.getVersion().getName());
        }

        return ls;
    }

    public Image getImage(String pokemonName) {
        DaoPokemon dg = new DaoPokemon();
        return dg.getImage(pokemonName);
    }

    public List<String> getDataType(String typeName) {
        DaoPokemon dg = new DaoPokemon();
        List<String> tipos = new ArrayList<>();
        List<MovesItem> mv = dg.getDataTypes(typeName).getMoves();
        for (MovesItem mi : mv) {
            tipos.add(mi.getName());
        }

        return tipos;
    }
}
