public class Orc extends BadGuy 
{
	
   public Orc() 
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 10;
		chanceToHeal = 0.1;
		healMin = 1;
		healMax = 20;
      speed = 13;
      droppedXP = 10;

		super.setName("Orc");

	}//close Orc
   
}//close Orc