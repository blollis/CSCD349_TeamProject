public class Zombie extends BadGuy 
{
	
   public Zombie() 
   {
		//DVC
		HPMax = 30;
      HP = HPMax;
		hitChance = 0.9;
		damageMin = 1;
		damageMax = 6;
		chanceToHeal = 0.9;
		healMin = 1;
		healMax = 5;
      speed = 5;
      droppedXP = 5;

		super.setName("Zombie");

	}//close Zombie
   
}//close Zombie