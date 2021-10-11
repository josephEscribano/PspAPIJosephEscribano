package dao.modelos.types;

public class PokemonItem{
	private Pokemon pokemon;
	private int slot;

	public Pokemon getPokemon(){
		return pokemon;
	}

	public int getSlot(){
		return slot;
	}

	@Override
 	public String toString(){
		return 
			"PokemonItem{" + 
			"pokemon = '" + pokemon + '\'' + 
			",slot = '" + slot + '\'' + 
			"}";
		}
}
