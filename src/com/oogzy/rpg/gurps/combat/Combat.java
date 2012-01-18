package com.oogzy.rpg.gurps.combat;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.oogzy.rpg.Dice;
import com.oogzy.rpg.gurps.character.Character;

public class Combat
{
	static Logger logger = Logger.getLogger(Combat.class);

	private int currentTurn;

	private Character[] turns;

	public Character first()
	{
		if (turns == null)
			return null;

		return turns[0];
	}

	public static boolean attack(Character attacker, Character defender)
	{
		BasicConfigurator.configure();
		logger.info("-- Attack test --");

		int dAtk = Dice.roll(6, 3);
		logger.debug("Attacker " + attacker.getName() + " rolls " + dAtk);

		if (dAtk >= 17)
		{
			logger.debug(attacker.getName() + " automatic misses the attack...");
			return false;
		}

		int attackSkill = attacker.getAttackSkill();
		logger.debug("Attack skill points: " + attackSkill);

		if (dAtk > attackSkill)
		{
			logger.debug(attacker.getName() + " misses the attack...");
			return false;
		}

		logger.debug(attacker.getName() + " got the attack...");
		if (defend(defender, attacker))
		{
			return false;
		}

		logger.debug(attacker.getName() + " hits " + defender.getName() + ".");
		return true;
	}

	public static boolean defend(Character defender, Character attacker)
	{
		logger.info("-- Defense test --");

		int dDef = Dice.roll(6, 3);
		logger.debug("Defender " + defender.getName() + " rolls " + dDef);

		int totalDefense = defender.getTotalDefense();
		logger.debug("Total defense: " + totalDefense);

		if (dDef <= totalDefense)
		{
			logger.debug(defender.getName() + " defend the attack.");
			return true;
		}

		logger.debug(defender.getName() + " fails on defense.");
		return false;
	}

	public static int damage(Character character)
	{
		return 0;
	}

	public Character next()
	{
		int turn = getCurrentTurn();
		if (turn >= getTurns().length)
		{
			setCurrentTurn(0);
			return getTurns()[0];
		}

		turn++;
		setCurrentTurn(turn);
		return getTurns()[turn];
	}

	public void addCharacter(Character character)
	{
		if (turns == null)
		{
			turns = new Character[] { character };
			setCurrentTurn(-1);
			return;
		}

		Character[] chars = turns.clone();
		turns = new Character[chars.length + 1];

		for (int i = 0; i < turns.length; i++)
		{
			if (chars.length <= i)
			{
				turns[turns.length - 1] = character;
				break;
			}

			Character c = chars[i];
			// Current character on turn has greater speed.
			if (c.getSpeed() > character.getSpeed())
			{
				turns[i] = c;
			}
			// Characters are draw on speed test so must roll a 3d6.
			else if (c.getSpeed() == character.getSpeed())
			{
				int dice1 = 0;
				int dice2 = 0;
				while ((dice1 <= 0 || dice2 <= 0) || dice1 == dice2)
				{
					dice1 = Dice.roll(6, 3);
					dice2 = Dice.roll(6, 3);
				}

				turns[i] = (dice1 > dice2) ? c : character;
			}
			// Else new character owns speed check.
			else
			{
				turns[i] = character;
				character = c;
			}
		}
	}

	public int getSize()
	{
		if (getTurns() == null)
			return 0;

		return getTurns().length;
	}

	public void setCurrentTurn(int currentTurn)
	{
		this.currentTurn = currentTurn;
	}

	public int getCurrentTurn()
	{
		return this.currentTurn;
	}

	public Character[] getTurns()
	{
		return this.turns;
	}
}