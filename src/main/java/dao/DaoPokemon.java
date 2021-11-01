package dao;


import dao.modeloPropio.Mapeador;
import dao.modelos.generationData.Generation;
import dao.modelos.generationNames.Generaciones;
import dao.modelos.generationNames.ResultsItem;
import dao.modelos.pokemons.*;
import dao.modelos.types.Types;
import dao.retrofit.PokeApi;
import gui.ProducesNetworks;
import io.vavr.control.Either;
import javafx.scene.image.Image;
import lombok.extern.log4j.Log4j2;
import retrofit2.Response;
import utils.Constantes;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Log4j2
public class DaoPokemon {
    private final ProducesNetworks producesNetworks;
    private final Mapeador mapeador;


    @Inject
    public DaoPokemon(ProducesNetworks producesNetworks, Mapeador mapeador) {
        this.producesNetworks = producesNetworks;
        this.mapeador = mapeador;
    }

    public Either<String, List<ResultsItem>> getGeneraciones() {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<ResultsItem>> genNames = null;
        try {
            Response<Generaciones> response = pokeApi.getGeneraciones().execute();

            if (response.isSuccessful()) {
                if (response.body() != null) {
                    genNames = Either.right(mapeador.generacionesToGeneracionesPropio(response.body()).getResults());
                } else {
                    if (response.errorBody() != null) {
                        genNames = Either.left(response.errorBody().toString());
                    } else {
                        genNames = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);

        }


        return genNames;
    }

    public Either<String, List<dao.modelos.generationData.PokemonSpeciesItem>> getPokemonsByGeneration(String nameGeneration) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<dao.modelos.generationData.PokemonSpeciesItem>> listPokemon = null;
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(nameGeneration).execute();

            if (response.isSuccessful()) {
                if (response.body() != null) {
                    listPokemon = Either.right(mapeador.generationToGenerationPropio(response.body()).getPokemonSpecies());
                } else {
                    if (response.errorBody() != null) {
                        listPokemon = Either.left(response.errorBody().toString());
                    } else {
                        listPokemon = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }


            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return listPokemon;
    }

    public Either<String, String> getRegionName(String generationName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, String> region = null;
        try {
            Response<Generation> response = pokeApi.getPokemonByGeneration(generationName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    region = Either.right(mapeador.generationToGenerationPropio(response.body()).getMainRegion().getName());
                } else {
                    if (response.errorBody() != null) {
                        region = Either.left(response.errorBody().toString());
                    } else {
                        region = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }
                }

            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return region;
    }

    public Either<String, List<TypesItem>> getTypes(String pokemonName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<TypesItem>> listTypes = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    listTypes = Either.right(mapeador.pokemonToPokemonPropio(response.body()).getTypes());
                } else {
                    if (response.errorBody() != null) {
                        listTypes = Either.left(response.errorBody().toString());
                    } else {
                        listTypes = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return listTypes;
    }

    public Either<String, List<AbilitiesItemPokemons>> getAbilities(String pokemonName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<AbilitiesItemPokemons>> listAbilities = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    listAbilities = Either.right(mapeador.pokemonToPokemonPropio(response.body()).getAbilities());
                } else {
                    if (response.errorBody() != null) {
                        listAbilities = Either.left(response.errorBody().toString());
                    } else {
                        listAbilities = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return listAbilities;
    }

    public Either<String, List<StatsItem>> getStats(String pokemonName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<StatsItem>> listStats = null;

        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    listStats = Either.right(mapeador.pokemonToPokemonPropio(response.body()).getStats());
                } else {
                    if (response.errorBody() != null) {
                        listStats = Either.left(response.errorBody().toString());
                    } else {
                        listStats = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return listStats;
    }

    public Either<String, List<GameIndicesItem>> getGames(String pokemonName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<GameIndicesItem>> listGames = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    listGames = Either.right(mapeador.pokemonToPokemonPropio(response.body()).getGameIndices());
                } else {
                    if (response.errorBody() != null) {
                        listGames = Either.left(response.errorBody().toString());
                    } else {
                        listGames = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return listGames;
    }

    public Either<String, Image> getImage(String pokemonName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, Image> image = null;
        try {
            Response<Pokemon> response = pokeApi.getPokemon(pokemonName).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    image = Either.right(new Image(mapeador.pokemonToPokemonPropio(response.body()).getSprites().getOther().getOfficialArtwork().getFrontDefault()));

                } else {
                    if (response.errorBody() != null) {
                        image = Either.left(response.errorBody().toString());
                    } else {
                        image = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                    }

                }

            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return image;
    }

    public Either<String, List<dao.modelos.types.MovesItem>> getDataTypes(String typeName) {
        PokeApi pokeApi = producesNetworks.getRetrofit().create(PokeApi.class);
        Either<String, List<dao.modelos.types.MovesItem>> type = null;
        try {
            Response<Types> response = pokeApi.getTypes(typeName).execute();
            if (response.isSuccessful()) {
                type = Either.right(mapeador.typeToTypePropio(response.body()).getMoves());
            } else {
                if (response.errorBody() != null) {
                    type = Either.left(response.errorBody().toString());
                } else {
                    type = Either.left(Constantes.ERROR_OBTENER_RESPONSE);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return type;
    }

}
