public class ManBearPig extends BadGuy 
{
	
   public ManBearPig() 
   {
		//DVC
		HPMax = 60;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 15;
		chanceToHeal = 0.5;
		healMin = 1;
		healMax = 5;
      speed = 8;
      droppedXP = 15;

		super.setName("ManBearPig");

	}//close ManBearPig
   
}//close ManBearPig