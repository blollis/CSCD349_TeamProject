public class PerciseHit implements SpecialAttack
{
   public void specialAttack(Character attacker, Character defender)
   {
      public void useAttack(Character attacker, Character defender) 
      {
         BadGuy currentBadGuy = (BadGuy)defender;
      
         Random randomGenerator = new Random();

         //Skips the chance to hit so there is 100% chance to hit

  			//randomly generate amount of damage to be done within damage range
         int damageAmountTemp = randomGenerator.nextInt(attacker.damageMax - attacker.damageMin)+ 1;
        
         //take HP from monster
 			currentBadGuy.setHP(currentBadGuy.getHP() - damageAmountTemp);
  			System.out.println("Attack was successful for " + damageAmountTemp + " points damage! " + currentBadGuy.getName() + " has " + currentBadGuy.getHP() + " hit points remaining.");
            
         //if statement to find out if monster is dead
 			if (currentBadGuy.checkForLife()) 
         {
  				//randomly generate healChanceTemp determines if monster will heal
            double healChanceTemp = randomGenerator.nextDouble();
   
  				if (healChanceTemp < currentBadGuy.getChanceToHeal()) 
            {
  					//randomly generate amount to be healed within heal range
               int healAmountTemp = randomGenerator.nextInt((currentBadGuy.getHealMax() - currentBadGuy.getHealMin()) + 1) + currentBadGuy.getHealMin();
                  
               //set new HP for monster
 					currentBadGuy.setHP(currentBadGuy.getHP() + healAmountTemp);
   
  					System.out.println(currentBadGuy.getName() + " healed himself! He now has " + currentBadGuy.getHP() + " HP points.\n");
   
  				}//close temp <chanceToHeal
               
            //else healing fails
				else 
            {
  					System.out.println(currentBadGuy.getName() + " attempted to heal himself but failed. He still has " + currentBadGuy.getHP() + " HP points.\n");
  				}//close else
               
  			}//close currentBadGuy healing attempt
           
  		}   
            
   }   
}