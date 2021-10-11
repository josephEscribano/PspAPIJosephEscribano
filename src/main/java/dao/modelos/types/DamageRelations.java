package dao.modelos.types;

import java.util.List;

public class DamageRelations{
	private List<NoDamageFromItem> noDamageFrom;
	private List<HalfDamageFromItem> halfDamageFrom;
	private List<NoDamageToItem> noDamageTo;
	private List<HalfDamageToItem> halfDamageTo;
	private List<DoubleDamageToItem> doubleDamageTo;
	private List<DoubleDamageFromItem> doubleDamageFrom;

	public List<NoDamageFromItem> getNoDamageFrom(){
		return noDamageFrom;
	}

	public List<HalfDamageFromItem> getHalfDamageFrom(){
		return halfDamageFrom;
	}

	public List<NoDamageToItem> getNoDamageTo(){
		return noDamageTo;
	}

	public List<HalfDamageToItem> getHalfDamageTo(){
		return halfDamageTo;
	}

	public List<DoubleDamageToItem> getDoubleDamageTo(){
		return doubleDamageTo;
	}

	public List<DoubleDamageFromItem> getDoubleDamageFrom(){
		return doubleDamageFrom;
	}

	@Override
 	public String toString(){
		return "no damage from = " + noDamageFrom + '\'' +
			"half damage from = " + halfDamageFrom + '\'' +
			"no damage to = " + noDamageTo + '\'' +
			"half damage to = " + halfDamageTo + '\'' +
			"double damage to = " + doubleDamageTo + '\'' +
			"double damage from = " + doubleDamageFrom + '\''
			;
		}
}