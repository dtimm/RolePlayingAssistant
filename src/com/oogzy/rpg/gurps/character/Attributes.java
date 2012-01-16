package com.oogzy.rpg.gurps.character;

public class Attributes
{
	private Character character;

	/**
	 * Strength, a measure of "brawn" or physical muscle.
	 */
	private int st;

	/**
	 * Dexteriry, a measure of agility and coordination.
	 */
	private int dx;

	/**
	 * Intelligence, a measure of brainpower, alertness, adaptability and
	 * general background experience.
	 */
	private int iq;

	/**
	 * Health, a measure of energy and vitality, HT also stands for "hits" - The
	 * amount of physical damage a character can take.
	 */
	private int ht;

	// @MappedBy
	public Character getCharacter()
	{
		return character;
	}

	public void setCharacter(Character character)
	{
		this.character = character;
	}

	public int getSt()
	{
		return st;
	}

	public void setSt(int st)
	{
		this.st = st;
	}

	public int getDx()
	{
		return dx;
	}

	public void setDx(int dx)
	{
		this.dx = dx;
	}

	public int getIq()
	{
		return iq;
	}

	public void setIq(int iq)
	{
		this.iq = iq;
	}

	public int getHt()
	{
		return ht;
	}

	public void setHt(int ht)
	{
		this.ht = ht;
	}
}