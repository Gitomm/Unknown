public class Attack
{
	private int baseDamage;
	private String type;

	public Attack(String ty, int bDamage)
	{
		baseDamage = bDamage;
		type = ty;
	}

	public int dmgValue(int res, int arm)
	{
		if (type.equals("Magic"))
		{
			return baseDamage*20 - res*5;
		}
		return baseDamage*20 - arm*5;
	}

}