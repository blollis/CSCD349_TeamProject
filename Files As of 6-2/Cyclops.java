public class Cyclops extends BadGuy 
{
	
   public Cyclops() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Cyclops", 50, 1, 20, 0.2D, 10, 0.1D, 1, 20, 8);
      
      //adds this character's special attack
      Attack attack = new Smash();
      
      attacksInventory.addAttack(attack);

	}//close Cyclops
   
}//close Cyclops