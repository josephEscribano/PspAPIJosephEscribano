package dao.modelos.stats;

public class DecreaseItem{
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
			"DecreaseItem{" + 
			"move = '" + move + '\'' + 
			",change = '" + change + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
