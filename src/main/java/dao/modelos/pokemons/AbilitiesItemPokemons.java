package dao.modelos.pokemons;

import com.google.gson.annotations.SerializedName;

public class AbilitiesItemPokemons {

	@SerializedName("is_hidden")
	private boolean isHidden;

	@SerializedName("ability")
	private Ability ability;

	@SerializedName("slot")
	private int slot;

	public boolean isIsHidden(){
		return isHidden;
	}

	public Ability getAbility(){
		return ability;
	}

	public int getSlot(){
		return slot;
	}

	@Override
 	public String toString(){
		return  slot + " " + ability.getName() ;
		}
}