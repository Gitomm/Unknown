public class Attack
{
	private int baseDamage;
	private String type;

	public Attack(String ty, int bDamage)
	{
		baseDamage = bDamage;
		type = ty;
	}

	public int dmgValue(Chara c)
	{
		if (type.equals("Magic"))
		{
			return baseDamage*20 - c.resistance*5;
		}
		return baseDamage*20 - c.armor*5;
	}

}