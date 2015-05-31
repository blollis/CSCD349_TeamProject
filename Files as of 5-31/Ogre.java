public class Ogre extends BadGuy 
{
	
   public Ogre() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Ogre", 45, 1, 12, 0.7D, 8, 0.1D, 1, 20, 9);
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Ogre
   
}//close Ogre