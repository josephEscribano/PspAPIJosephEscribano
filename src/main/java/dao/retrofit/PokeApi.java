package dao.retrofit;


import dao.modelos.generationData.Generation;
import dao.modelos.generationNames.Generaciones;
import dao.modelos.pokemons.Pokemon;
import dao.modelos.types.Types;
import retrofit2.Call;
import retrofit2.http.*;

public interface PokeApi {

    @GET("generation")
    Call<Generaciones> getGeneraciones();

    @GET("generation/{GenerationName}")
    Call<Generation> getPokemonByGeneration(@Path("GenerationName") String nGeneration);

    @GET("pokemon/{PokemonName}")
    Call<Pokemon> getPokemon(@Path("PokemonName") String nPokemon);

    @GET("type/{TypeName}")
    Call<Types> getTypes(@Path("TypeName") String nType);
}
