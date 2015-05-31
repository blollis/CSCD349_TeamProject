public class Cyclops extends BadGuy 
{
	
   public Cyclops() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Cyclops", 50, 1, 20, 0.2D, 10, 0.1D, 1, 20, 8);
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Cyclops
   
}//close Cyclops