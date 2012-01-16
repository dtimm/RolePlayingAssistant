package com.oogzy.rpg.gurps.damage;

import com.oogzy.rpg.Dice;

public class Damage
{
	private int diceSides;

	private int dices;

	private int modifier;

	public Damage(int sides, int dices, int mod)
	{
		setDiceSides(sides);
		setDices(dices);
		setModifier(mod);
	}

	public int roll()
	{
		int sum = 0;
		for (int i = 0; i < dices; i++)
		{
			sum += Dice.roll(getDiceSides(), getDices());
		}
		return sum + getModifier();
	}

	public int getDiceSides()
	{
		return diceSides;
	}

	public void setDiceSides(int diceSides)
	{
		this.diceSides = diceSides;
	}

	public int getDices()
	{
		return dices;
	}

	public void setDices(int dices)
	{
		this.dices = dices;
	}

	public int getModifier()
	{
		return modifier;
	}

	public void setModifier(int modifier)
	{
		this.modifier = modifier;
	}
}