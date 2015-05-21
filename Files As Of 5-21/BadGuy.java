import java.util.Scanner;
import java.util.Random;

public abstract class BadGuy extends Character 
{
	protected double chanceToHeal;
	protected int healMin;
	protected int healMax;
   //used to determine amount of XP goodGuy can get when they kill this badGuy
   protected int droppedXP;

	public BadGuy() 
   {
		super();
		healMin = 0;
		healMax = 0;
      droppedXP = 0;
      
      //every badGuy starts off with same default attack
      Attack defaultAttack = new DefaultBadGuyAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
   }//close BadGuy

	public void setHealMin(int healMinInput) 
   {
		healMin = healMinInput;
	}//close sethealMin    

	public int getHealMin() 
   {
		return healMin;
	}//close gethealMin

	public void setHealMax(int healMaxInput) 
   {
		healMax = healMaxInput;
	}//close sethealMax    

	public int getHealMax() 
   {
		return healMax;
	}//close gethealMax

	public void setChanceToHeal(double chanceToHealInput) 
   {
		chanceToHeal = chanceToHealInput;
	}//close setchanceToHeal    

	public double getChanceToHeal() 
   {
		return chanceToHeal;
	}//close getchanceToHeal
   
   //not used right now
   public boolean validAttackChoice(int x) {
      return true;
   }

	public int  getDroppedXP() 
   {
		return droppedXP;
	}//close getDroppedXP
   
}//close BadGuy