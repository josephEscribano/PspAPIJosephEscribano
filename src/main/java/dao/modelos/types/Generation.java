package dao.modelos.types;

public class Generation{
	private String name;
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Generation{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
