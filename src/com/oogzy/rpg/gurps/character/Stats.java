package com.oogzy.rpg.gurps.character;

public class Stats
{
	private Character character;

	private int pointsTotal;

	private int unspentPoints;

	/**
	 * Hits taken
	 */
	private int hitsTaken;

	/**
	 * Perception
	 */
	private int perception;

	// @MappedBy
	public Character getCharacter()
	{
		return character;
	}

	public void setCharacter(Character character)
	{
		this.character = character;
	}

	/**
	 * Hit Points
	 */
	public int getHp()
	{
		return getCharacter().getAttributes().getHt();
	}

	/**
	 * Fatigue Points
	 */
	private int fatigue;

	public int getPointsTotal()
	{
		return pointsTotal;
	}

	public void setPointsTotal(int pointsTotal)
	{
		this.pointsTotal = pointsTotal;
	}

	public int getUnspentPoints()
	{
		return unspentPoints;
	}

	public void setUnspentPoints(int unspentPoints)
	{
		this.unspentPoints = unspentPoints;
	}

	public int getHitsTaken()
	{
		return hitsTaken;
	}

	public void setHitsTaken(int hitsTaken)
	{
		this.hitsTaken = hitsTaken;
	}

	public int getPerception()
	{
		return perception;
	}

	public void setPerception(int perception)
	{
		this.perception = perception;
	}

	public int getFatigue()
	{
		return fatigue;
	}

	public void setFatigue(int fatigue)
	{
		this.fatigue = fatigue;
	}

	public void addDamage(int dmg)
	{
		setHitsTaken(getHitsTaken() + dmg);
	}
}