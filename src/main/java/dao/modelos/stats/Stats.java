package dao.modelos.stats;

import java.util.List;

public class Stats{
	private int gameIndex;
	private List<CharacteristicsItem> characteristics;
	private MoveDamageClass moveDamageClass;
	private List<NamesItem> names;
	private String name;
	private boolean isBattleOnly;
	private AffectingMoves affectingMoves;
	private int id;
	private AffectingNatures affectingNatures;

	public int getGameIndex(){
		return gameIndex;
	}

	public List<CharacteristicsItem> getCharacteristics(){
		return characteristics;
	}

	public MoveDamageClass getMoveDamageClass(){
		return moveDamageClass;
	}

	public List<NamesItem> getNames(){
		return names;
	}

	public String getName(){
		return name;
	}

	public boolean isIsBattleOnly(){
		return isBattleOnly;
	}

	public AffectingMoves getAffectingMoves(){
		return affectingMoves;
	}

	public int getId(){
		return id;
	}

	public AffectingNatures getAffectingNatures(){
		return affectingNatures;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"game_index = '" + gameIndex + '\'' + 
			",characteristics = '" + characteristics + '\'' + 
			",move_damage_class = '" + moveDamageClass + '\'' + 
			",names = '" + names + '\'' + 
			",name = '" + name + '\'' + 
			",is_battle_only = '" + isBattleOnly + '\'' + 
			",affecting_moves = '" + affectingMoves + '\'' + 
			",id = '" + id + '\'' + 
			",affecting_natures = '" + affectingNatures + '\'' + 
			"}";
		}
}