package com.oogzy.rpg.gurps.damage;

import java.util.HashMap;
import java.util.Map;

public class DamageTable
{
	public static Damage getAttack(Attack type, int st)
	{
		if (Attack.SWING.equals(type))
		{
			return DamageTable.SWING.get(st);
		}
		if (Attack.THRUST.equals(type))
		{
			return DamageTable.THRUST.get(st);
		}

		return null;
	}

	public enum Attack
	{
		THRUST, SWING;
	}

	public static Map<Integer, Damage> THRUST = new HashMap<Integer, Damage>();
	static
	{
		THRUST.put(1, new Damage(6, 0, 0));
		THRUST.put(2, new Damage(6, 0, 0));
		THRUST.put(3, new Damage(6, 0, 0));
		THRUST.put(4, new Damage(6, 0, 0));
		THRUST.put(5, new Damage(6, 1, -5));
		THRUST.put(6, new Damage(6, 1, -4));
		THRUST.put(7, new Damage(6, 1, -3));
		THRUST.put(8, new Damage(6, 1, -3));
		THRUST.put(9, new Damage(6, 1, -2));
		THRUST.put(10, new Damage(6, 1, -2));
		THRUST.put(11, new Damage(6, 1, -1));
		THRUST.put(12, new Damage(6, 1, -1));
		THRUST.put(13, new Damage(6, 1, 0));
		THRUST.put(14, new Damage(6, 1, 0));
		THRUST.put(15, new Damage(6, 1, 1));
		THRUST.put(16, new Damage(6, 1, 1));
		THRUST.put(17, new Damage(6, 1, 2));
		THRUST.put(18, new Damage(6, 1, 2));
		THRUST.put(19, new Damage(6, 2, -3));
		THRUST.put(20, new Damage(6, 2, -1));
	}

	public static Map<Integer, Damage> SWING = new HashMap<Integer, Damage>();
	static
	{
		SWING.put(1, new Damage(6, 0, 0));
		SWING.put(2, new Damage(6, 0, 0));
		SWING.put(3, new Damage(6, 0, 0));
		SWING.put(4, new Damage(6, 0, 0));
		SWING.put(5, new Damage(6, 1, -5));
		SWING.put(6, new Damage(6, 1, -4));
		SWING.put(7, new Damage(6, 1, -3));
		SWING.put(8, new Damage(6, 1, -2));
		SWING.put(9, new Damage(6, 1, -1));
		SWING.put(10, new Damage(6, 1, 0));
		SWING.put(11, new Damage(6, 1, 1));
		SWING.put(12, new Damage(6, 1, 2));
		SWING.put(13, new Damage(6, 2, -1));
		SWING.put(14, new Damage(6, 2, 0));
		SWING.put(15, new Damage(6, 2, 1));
		SWING.put(16, new Damage(6, 2, 2));
		SWING.put(17, new Damage(6, 3, 2));
		SWING.put(18, new Damage(6, 3, 2));
		SWING.put(19, new Damage(6, 3, -3));
		SWING.put(20, new Damage(6, 3, -1));
	}
}