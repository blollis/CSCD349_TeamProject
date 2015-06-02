public class Orc extends BadGuy 
{
	
   public Orc() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Orc", 50, 1, 10, 0.6D, 13, 0.1D, 1, 20, 10);
      
      //adds this character's special attack
      Attack attack = new BloodLust();
      
      attacksInventory.addAttack(attack);

	}//close Orc
   
}//close Orc