package dao.modeloPropio;

import dao.modelos.generationData.PokemonSpeciesItem;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class GenerationPropio {

    private dao.modelos.generationData.MainRegion mainRegion;
    private List<PokemonSpeciesItem> pokemonSpecies;
}
