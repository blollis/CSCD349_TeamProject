import java.util.Scanner;

public abstract class GoodGuy extends Character
{
	private Scanner kb = new Scanner(System.in);
	
	public GoodGuy(int hp, int atkDmg, int eva, int def, int speed, boolean npc)
	{
		super(hp, atkDmg, eva, def, speed, npc);
		requestName();
	} //End of EVC(int, int, int, int, int, boolean)
   
   public boolean isNPC()
   {
      return npc;
   }
   
   public void requestName()
   {
      System.out.println("What is your name: ");
      this.setName(kb.nextLine());
   }
      
   public int getHp()
   {
      return hp;
   }// End of getHp()
   
   public void setHp(int health)
   {
      this.hp = health;
   }
			
	public int getDef()
	{
		return def;
	} //End of getDef()
   
   public int getEva()
   {
      return eva;
   }
   
   public int getDmg()
   {
      return dmg;
   }
   
   public int getSpeed()
   {
      return speed;
   }

} //End of Hero Class