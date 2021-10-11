package dao.modelos.types;

import java.util.List;

public class Types{
	private Generation generation;
	private List<GameIndicesItem> gameIndices;
	private MoveDamageClass moveDamageClass;
	private List<NamesItem> names;
	private List<PokemonItem> pokemon;
	private DamageRelations damageRelations;
	private List<MovesItem> moves;
	private String name;
	private int id;

	public Generation getGeneration(){
		return generation;
	}

	public List<GameIndicesItem> getGameIndices(){
		return gameIndices;
	}

	public MoveDamageClass getMoveDamageClass(){
		return moveDamageClass;
	}

	public List<NamesItem> getNames(){
		return names;
	}

	public List<PokemonItem> getPokemon(){
		return pokemon;
	}

	public DamageRelations getDamageRelations(){
		return damageRelations;
	}

	public List<MovesItem> getMoves(){
		return moves;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Types{" + 
			"generation = '" + generation + '\'' + 
			",game_indices = '" + gameIndices + '\'' + 
			",move_damage_class = '" + moveDamageClass + '\'' + 
			",names = '" + names + '\'' + 
			",pokemon = '" + pokemon + '\'' + 
			",damage_relations = '" + damageRelations + '\'' + 
			",moves = '" + moves + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}