package dao.modelos.generationData;

import com.google.gson.annotations.SerializedName;

public class NamesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("language")
	private dao.modelos.generationData.Language language;

	public String getName(){
		return name;
	}

	public dao.modelos.generationData.Language getLanguage(){
		return language;
	}

	@Override
 	public String toString(){
		return 
			"NamesItem{" + 
			"name = '" + name + '\'' + 
			",language = '" + language + '\'' + 
			"}";
		}
}