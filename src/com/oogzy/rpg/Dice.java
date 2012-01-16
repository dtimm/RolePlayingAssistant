package com.oogzy.rpg;

public class Dice
{
	public static int roll(int sides)
	{
		return (int) Math.abs(Math.random() * sides) + 1;
	}

	public static int roll(int sides, int times)
	{
		int sum = 0;
		for (int i = 1; i <= times; i++)
		{
			sum += roll(sides);
		}
		return sum;
	}
}