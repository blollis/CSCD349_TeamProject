public class ManBearPig extends BadGuy 
{
	
   public ManBearPig() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("ManBearPig", 60, 1, 20, 0.6D, 8, 0.4D, 1, 5, 10);
      
      //adds this character's special attack
      Attack attack = new Slash();
      
      attacksInventory.addAttack(attack);

	}//close ManBearPig
   
}//close ManBearPig