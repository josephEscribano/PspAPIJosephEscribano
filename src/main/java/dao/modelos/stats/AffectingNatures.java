package dao.modelos.stats;

import java.util.List;

public class AffectingNatures{
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
			"AffectingNatures{" + 
			"increase = '" + increase + '\'' + 
			",decrease = '" + decrease + '\'' + 
			"}";
		}
}