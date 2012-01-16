package com.oogzy.rpg.gurps.item.weapon;

public enum WeaponDamage
{
	/**
	 * Impaling weapons are those that strike with a sharp point. <br>
	 * When you hit with an impaling weapon, the damage that gets through the
	 * armor is doubled.
	 */
	IMPALING,

	/**
	 * Cutting weapons strike with an edge. <br>
	 * When you hit with a cutting weapon, all damage that gets through the
	 * target's armor is increased by 50%, rounded down.
	 */
	CUTTING,

	/**
	 * Crushing weapons strike with a blunt surface. <br>
	 * They score no bonus damage.
	 */
	CRUSHING;

	public boolean isImpaling()
	{
		return WeaponDamage.IMPALING.equals(this);
	}

	public boolean isCutting()
	{
		return WeaponDamage.CUTTING.equals(this);
	}

	public boolean isCrushing()
	{
		return WeaponDamage.CRUSHING.equals(this);
	}
}