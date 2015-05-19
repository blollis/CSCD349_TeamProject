import java.util.Random;
import java.util.Scanner;

public class Wizard extends GoodGuy {

	public Wizard() {
		//DVC
		super();
		HPMax = 100;
      HP = HPMax;
		hitChance = 0.7;
		damageMin = 50;
		damageMax = 120;
		specialAttack = "Soothe";
      speed = 9;
      
      super.setName("Wally the Wizard");

	}//close Wizard

	public void specialAttack(BadGuy currentBadGuy) {
		Random randomGenerator = new Random();
      
      //randomly generate chance that attack will succeed
		double attackChanceTemp = randomGenerator.nextDouble();
      
      //if succeeds, change damage min and max for monter
		if (attackChanceTemp < 0.15) {
			currentBadGuy.setDamageMin(10);
         currentBadGuy.setDamageMax(20);
         System.out.println("You successfully soothed the monster!" + currentBadGuy.getName() + " will now only deal between 10 and 20 damage points with any regular attack.\n");  
		}//close if
      //else if attack fails
		else {
			System.out.println("Your attempt to soothe the monster failed!\n");
		}//close else

	}//close specialattack soothe
   
   public boolean validAttackChoice(int x) 
   {
      if (x >= 0 && x < attacksInventory.size()) {
         return true;
      }
      
      return false;
   }

}//close Wizard