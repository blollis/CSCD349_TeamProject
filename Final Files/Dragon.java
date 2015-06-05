public class Dragon extends BadGuy 
{
	
   public Dragon() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Dragon", 75, 1, 20, 0.8D, 15, 0.1D, 1, 20, 20);
      
      //adds this character's special attack
      Attack attack = new FireBreath();
      
      attacksInventory.addAttack(attack);

	}//close Dragon
   
}//close Dragon