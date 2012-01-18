package com.oogzy.rpg.gurps.combat;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.oogzy.rpg.gurps.character.Character;

public class CombatTest
{
	static Logger logger = Logger.getLogger(CombatTest.class);

	@Test
	public void test_combat_1()
	{
		Character char1 = new Character();
		char1.setName("Char01");
		char1.getAttributes().setDx(10);
		char1.getAttributes().setHt(10);
		char1.getAttributes().setSt(10);

		Character char2 = new Character();
		char2.setName("Char02");
		char2.getAttributes().setDx(6);
		char2.getAttributes().setHt(10);
		char2.getAttributes().setSt(10);

		if (Combat.attack(char1, char2))
		{
			int dmg = char1.getDamage().roll();
			logger.debug(char1.getName() + " damages " + dmg + " points on " + char2.getName());
			char2.damage(dmg);
		}
	}

	@Test
	public void test_addCharacter_1()
	{
		Combat combat = new Combat();

		Character char1 = new Character();
		char1.setName("Char10+10");
		char1.getAttributes().setDx(10);
		char1.getAttributes().setHt(10);

		combat.addCharacter(char1);

		Character char3 = new Character();
		char3.setName("Char6+10");
		char3.getAttributes().setDx(6);
		char3.getAttributes().setHt(10);

		combat.addCharacter(char3);

		Character char2 = new Character();
		char2.setName("Char14+10");
		char2.getAttributes().setDx(14);
		char2.getAttributes().setHt(10);

		combat.addCharacter(char2);

		for (Character c : combat.getTurns())
		{
			logger.debug(c.getName() + " > Speed:" + c.getSpeed());
		}
	}

	@Test
	public void test_addCharacter_2()
	{
		Combat combat = new Combat();

		Character char1 = new Character();
		char1.setName("Char8+10");
		char1.getAttributes().setDx(8);
		char1.getAttributes().setHt(10);

		combat.addCharacter(char1);

		Character char3 = new Character();
		char3.setName("Char12+12");
		char3.getAttributes().setDx(12);
		char3.getAttributes().setHt(12);

		combat.addCharacter(char3);

		Character char2 = new Character();
		char2.setName("Char14+10");
		char2.getAttributes().setDx(14);
		char2.getAttributes().setHt(10);

		combat.addCharacter(char2);

		for (Character c : combat.getTurns())
		{
			logger.debug(c.getName() + " > Speed:" + c.getSpeed());
		}
	}
}