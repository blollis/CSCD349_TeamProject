import java.util.Random;

public abstract class Character
{
	protected String name;
	protected int hitPoints;
	protected int attackDamage;
	protected int evasion;
	protected int defense;
   protected int attackSpeed;
   protected int initiative;
   protected boolean npc;
	protected Random randomGenerator = new Random();
	
	public void DungeonCharacter(int hp, int atkDmg, int eva, int def, int speed, boolean cpu)
	{
		hitPoints = hp;
		attackDamage = atkDmg;
		evasion = eva;
		defense = def;
		attackSpeed = speed;
      npc = cpu;
	} //End of EVC(int, int, int, int, int, boolean)
   
   public boolean isNPC()
   {
      return npc;
   }
   
	public void setName(String name)
	{
		this.name = name;
	} //End of setName(String)
	
	public String getName()
	{
		return name;
	} //End of getName()
	
	public void setHp(int hp)
	{
		hitPoints = hp;
	} //End of setHP(int)
	
	public int getHp()
	{
		return hitPoints;
	} //End of getHP()
	
	public void setAtkDmg(int atkDmg)
	{
		attackDamage = atkDmg;
	} //End of 
	
	public int getAtkDmg()
	{
		return attackDamage;
	} //End of 
	
	public void setEva(int eva)
	{
		evasion = eva;
	} //End of 
	
	public int getEva()
	{
		return evasion;
	} //End of 
	
	public void setDef(int def)
	{
		defense = def;
	} //End of
	
	public int getDef()
	{
		return defense;
	} //End of 
	
	public void setSpeed(int speed)
	{
		attackSpeed = speed;
	} //End of 
	
	public int getSpeed()
	{
		return attackSpeed;
	} //End of
   
   public void setInit(int inti)
   {
      initiative = inti;
   }
   
   public int getInit()
   {
      return initiative;
   }
	
} //End of Character Class
	