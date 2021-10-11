package dao.modelos.stats;

public class NamesItem{
	private String name;
	private Language language;

	public String getName(){
		return name;
	}

	public Language getLanguage(){
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
