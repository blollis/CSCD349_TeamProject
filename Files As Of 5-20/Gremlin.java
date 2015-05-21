public class Gremlin extends BadGuy 
{
	
   public Gremlin() 
   {
		//DVC
		HPMax = 30;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 10;
		chanceToHeal = 0.3;
		healMin = 1;
		healMax = 10;
      speed = 17;
      droppedXP = 8;

		super.setName("Gremlin");

	}//close Gremlin
   
}//close Gremlin