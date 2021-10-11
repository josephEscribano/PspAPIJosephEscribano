package dao.modelos.types;

public class GameIndicesItem{
	private Generation generation;
	private int gameIndex;

	public Generation getGeneration(){
		return generation;
	}

	public int getGameIndex(){
		return gameIndex;
	}

	@Override
 	public String toString(){
		return 
			"GameIndicesItem{" + 
			"generation = '" + generation + '\'' + 
			",game_index = '" + gameIndex + '\'' + 
			"}";
		}
}
