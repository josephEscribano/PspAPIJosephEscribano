package dao.modelos.stats;

import java.util.List;

public class AffectingMoves{
	private List<IncreaseItem> increase;
	private List<DecreaseItem> decrease;

	public List<IncreaseItem> getIncrease(){
		return increase;
	}

	public List<DecreaseItem> getDecrease(){
		return decrease;
	}

	@Override
 	public String toString(){
		return 
			"AffectingMoves{" + 
			"increase = '" + increase + '\'' + 
			",decrease = '" + decrease + '\'' + 
			"}";
		}
}