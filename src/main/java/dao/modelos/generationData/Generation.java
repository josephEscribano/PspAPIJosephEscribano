package dao.modelos.generationData;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Generation{

	@SerializedName("abilities")
	private List<dao.modelos.generationData.AbilitiesItem> abilities;

	@SerializedName("types")
	private List<TypesItemGeneration> types;

	@SerializedName("names")
	private List<dao.modelos.generationData.NamesItem> names;

	@SerializedName("main_region")
	private dao.generationData.MainRegion mainRegion;

	@SerializedName("version_groups")
	private List<dao.modelos.generationData.VersionGroupsItem> versionGroups;

	@SerializedName("moves")
	private List<dao.generationData.MovesItem> moves;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("pokemon_species")
	private List<dao.modelos.generationData.PokemonSpeciesItem> pokemonSpecies;

	public List<dao.modelos.generationData.AbilitiesItem> getAbilities(){
		return abilities;
	}

	public List<TypesItemGeneration> getTypes(){
		return types;
	}

	public List<dao.modelos.generationData.NamesItem> getNames(){
		return names;
	}

	public dao.generationData.MainRegion getMainRegion(){
		return mainRegion;
	}

	public List<dao.modelos.generationData.VersionGroupsItem> getVersionGroups(){
		return versionGroups;
	}

	public List<dao.generationData.MovesItem> getMoves(){
		return moves;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public List<dao.modelos.generationData.PokemonSpeciesItem> getPokemonSpecies(){
		return pokemonSpecies;
	}

	@Override
 	public String toString(){
		return 
			"Generation{" + 
			"abilities = '" + abilities + '\'' + 
			",types = '" + types + '\'' + 
			",names = '" + names + '\'' + 
			",main_region = '" + mainRegion + '\'' + 
			",version_groups = '" + versionGroups + '\'' + 
			",moves = '" + moves + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",pokemon_species = '" + pokemonSpecies + '\'' + 
			"}";
		}
}