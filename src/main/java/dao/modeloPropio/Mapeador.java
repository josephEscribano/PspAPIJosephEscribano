package dao.modeloPropio;

import dao.modelos.generationData.Generation;
import dao.modelos.generationNames.Generaciones;
import dao.modelos.pokemons.Pokemon;
import dao.modelos.types.Types;
import org.modelmapper.ModelMapper;


public class Mapeador {
    private final ModelMapper modelMapper = new ModelMapper();


    public GeneracionesPropio generacionesToGeneracionesPropio(Generaciones generaciones) {
        return modelMapper.typeMap(Generaciones.class, GeneracionesPropio.class)
                .addMapping(Generaciones::getResults, GeneracionesPropio::setResults)
                .map(generaciones);
    }

    public GenerationPropio generationToGenerationPropio(Generation generation) {
        return modelMapper.typeMap(Generation.class, GenerationPropio.class)
                .addMapping(Generation::getMainRegion, GenerationPropio::setMainRegion)
                .addMapping(Generation::getPokemonSpecies, GenerationPropio::setPokemonSpecies)
                .map(generation);
    }

    public PokemonPropio pokemonToPokemonPropio(Pokemon pokemon) {
        return modelMapper.typeMap(Pokemon.class, PokemonPropio.class)
                .addMapping(Pokemon::getAbilities, PokemonPropio::setAbilities)
                .addMapping(Pokemon::getStats, PokemonPropio::setStats)
                .addMapping(Pokemon::getGameIndices, PokemonPropio::setGameIndices)
                .addMapping(Pokemon::getSprites, PokemonPropio::setSprites)
                .addMapping(Pokemon::getTypes, PokemonPropio::setTypes)
                .map(pokemon);

    }

    public TypesPropio typeToTypePropio(Types type) {
        return modelMapper.typeMap(Types.class, TypesPropio.class)
                .addMapping(Types::getMoves, TypesPropio::setMoves)
                .map(type);

    }
}
