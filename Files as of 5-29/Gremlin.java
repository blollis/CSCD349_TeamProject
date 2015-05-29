public class Gremlin extends BadGuy 
{
	
   public Gremlin() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Gremlin", 30, 1, 10, 0.6D, 17, 0.3D, 1, 5, 6);
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Gremlin
   
}//close Gremlin