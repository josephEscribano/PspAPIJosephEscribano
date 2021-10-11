package dao.modelos.stats;

public class IncreaseItem{
	private Move move;
	private int change;
	private String name;
	private String url;

	public Move getMove(){
		return move;
	}

	public int getChange(){
		return change;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"IncreaseItem{" + 
			"move = '" + move + '\'' + 
			",change = '" + change + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
