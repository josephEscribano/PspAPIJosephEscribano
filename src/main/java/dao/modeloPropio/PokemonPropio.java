package dao.modeloPropio;

import dao.modelos.pokemons.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class PokemonPropio {
    private List<TypesItem> types;
    private List<AbilitiesItemPokemons> abilities;
    private List<StatsItem> stats;
    private List<GameIndicesItem> gameIndices;
    private Sprites sprites;
}
