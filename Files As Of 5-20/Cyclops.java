public class Cyclops extends BadGuy 
{
	
   public Cyclops() 
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.4;
		damageMin = 1;
		damageMax = 20;
		chanceToHeal = 0.1;
		healMin = 1;
		healMax = 20;
      speed = 10;
      droppedXP = 12;

		super.setName("Cyclops");

	}//close Cyclops
   
}//close Cyclops