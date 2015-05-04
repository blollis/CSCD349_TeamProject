import java.util.Random;
import java.util.Scanner;

public class Elf extends GoodGuy 
{

	public Elf()
   {
		//DVC
		super();
		HP = 120;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
		specialAttack = "Soothe";
      speed = 10;
      
      super.setName("Elf");

	}//close Elf

	public void specialAttack(BadGuy currentBadGuy) 
   {
		Random randomGenerator = new Random();
      
      //randomly generate chance that attack will succeed
		double attackChanceTemp = randomGenerator.nextDouble();
      
      //if succeeds, change damage min and max for monter
		if (attackChanceTemp < 0.15) 
      {
			currentBadGuy.setDamageMin(10);
         currentBadGuy.setDamageMax(20);
         System.out.println("You successfully soothed the monster!" + currentBadGuy.getName() + " will now only deal between 10 and 20 damage points with any regular attack.\n");  
		}//close if
      //else if attack fails
		else 
      {
			System.out.println("Your attempt to soothe the monster failed!\n");
		}//close else

	}//close specialattack soothe
   
   public boolean validAttackChoice(int x) 
   {
   
      if (attackChoices.indexOf(x) == -1) {
         return false;
      }
      
      return true;   
   }//close validAttackChoice
   
}//close Elf