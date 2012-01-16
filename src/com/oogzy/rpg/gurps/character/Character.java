package com.oogzy.rpg.gurps.character;

import java.util.Calendar;

import com.oogzy.rpg.gurps.character.skill.Skill;
import com.oogzy.rpg.gurps.combat.Combat;
import com.oogzy.rpg.gurps.damage.Damage;
import com.oogzy.rpg.gurps.damage.DamageTable;
import com.oogzy.rpg.gurps.damage.DamageTable.Attack;
import com.oogzy.rpg.gurps.item.Item;
import com.oogzy.rpg.gurps.item.weapon.Weapon;

public class Character
{
	private String name;

	private Calendar createDate;

	private Item selectedItem;

	private Skill selectedSkill;

	private Appearance appearance;

	private Wealth wealth;

	private Attributes attributes;

	private Stats stats;

	private int positionX;

	private int positionY;

	public Character()
	{
		setStats(new Stats());
		setAttributes(new Attributes());
		setCreateDate(Calendar.getInstance());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Calendar getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Calendar createDate)
	{
		this.createDate = createDate;
	}

	public Item getSelectedItem()
	{
		return selectedItem;
	}

	public void setSelectedItem(Item selectedItem)
	{
		this.selectedItem = selectedItem;
	}

	public Skill getSelectedSkill()
	{
		return selectedSkill;
	}

	public void setSelectedSkill(Skill selectedSkill)
	{
		this.selectedSkill = selectedSkill;
	}

	public Attributes getAttributes()
	{
		return attributes;
	}

	public void setAttributes(Attributes attributes)
	{
		this.attributes = attributes;
	}

	public Stats getStats()
	{
		return stats;
	}

	public void setStats(Stats stats)
	{
		this.stats = stats;
	}

	public Appearance getAppearance()
	{
		return appearance;
	}

	public void setAppearance(Appearance appearance)
	{
		this.appearance = appearance;
	}

	public Wealth getWealth()
	{
		return wealth;
	}

	public void setWealth(Wealth wealth)
	{
		this.wealth = wealth;
	}

	public int getPositionX()
	{
		return positionX;
	}

	public void setPositionX(int positionX)
	{
		this.positionX = positionX;
	}

	public int getPositionY()
	{
		return positionY;
	}

	public void setPositionY(int positionY)
	{
		this.positionY = positionY;
	}

	// @Transient
	public float getSpeed()
	{
		Attributes attr = getAttributes();
		return (attr.getHt() + attr.getDx()) / 4;
	}

	// @Transient
	public int getMove()
	{
		return (int) Math.abs(getSpeed());
	}

	// @Transient
	public int getWill()
	{
		// IQ + advantages like Strong will, ...
		return getAttributes().getIq();
	}

	// @Transient
	public int getAttackSkill()
	{
		// TODO get active skill.
		return getAttributes().getDx();
	}

	// @Transient
	public int getTotalDefense()
	{
		// TODO Calculate total defense (passive + active).
		// TODO Choose the best active defence (Dodge, Block or Parry).
		return getMove();
	}

	public Damage getDamage()
	{
		// TODO Choose skill, weapon, etc..
		return DamageTable.getAttack(Attack.THRUST, getAttributes().getSt());
	}

	public void damage(int dmg)
	{
		getStats().addDamage(dmg);
	}

	// @Transient
	public Weapon getWeapon()
	{
		return null;
	}

	public boolean attack(Character target)
	{
		return Combat.attack(this, target);
	}
}