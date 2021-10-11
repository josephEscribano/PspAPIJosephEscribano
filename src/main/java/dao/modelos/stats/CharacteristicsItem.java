package dao.modelos.stats;

public class CharacteristicsItem{
	private String url;

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"CharacteristicsItem{" + 
			"url = '" + url + '\'' + 
			"}";
		}
}
