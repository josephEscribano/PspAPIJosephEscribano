package dao.modelos.versions;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Version{

	@SerializedName("names")
	private List<NamesItem> names;

	@SerializedName("version_group")
	private VersionGroup versionGroup;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public List<NamesItem> getNames(){
		return names;
	}

	public VersionGroup getVersionGroup(){
		return versionGroup;
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
			"Version{" + 
			"names = '" + names + '\'' + 
			",version_group = '" + versionGroup + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}