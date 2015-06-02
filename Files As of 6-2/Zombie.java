public class Zombie extends BadGuy 
{
	
   public Zombie() 
   {
		//BadGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed, double chanceToHeal, int healMin, int healMax, int droppedXP)
      super("Zombie", 30, 1, 6, 0.9D, 5, 0.9D, 1, 5, 5);
      
      //adds this character's special attack
      Attack attack = new Bite();
      
      attacksInventory.addAttack(attack);


	}//close Zombie
   
}//close Zombie