package dao.modelos.generationNames;

import com.google.gson.annotations.SerializedName;
import lombok.ToString;

@ToString
public class ResultsItem{

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}