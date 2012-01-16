package com.oogzy.rpg;

import junit.framework.TestCase;

import org.junit.Test;

public class DiceTest extends TestCase
{
	@Test
	public void test_roll_dices()
	{
		for (int i = 0; i < 1000; i++)
		{
			int roll = Dice.roll(6, 3);
			if (roll < 3 || roll > 18)
				System.out.println(roll);
		}

		for (int i = 0; i < 1000; i++)
		{
			int roll = Dice.roll(6);
			if (roll < 1 || roll > 6)
				System.out.println(roll);
		}
	}
}