public class Skeleton extends BadGuy 
{
	
   public Skeleton() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Skeleton", 20, 1, 8, 0.8D, 14, 0.3D, 1, 6, 5);
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Skeleton
   
}//close Skeleton