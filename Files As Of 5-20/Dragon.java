public class Dragon extends BadGuy 
{
	
   public Dragon() 
   {
		//DVC
		HPMax = 75;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 20;
		chanceToHeal = 0.1;
		healMin = 1;
		healMax = 20;
      speed = 15;
      droppedXP = 20;

		super.setName("Dragon");

	}//close Dragon
   
}//close Dragon