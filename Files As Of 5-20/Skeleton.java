public class Skeleton extends BadGuy 
{
	
   public Skeleton() 
   {
		//DVC
		HPMax = 20;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 8;
		chanceToHeal = 0.3;
		healMin = 1;
		healMax = 6;
      speed = 14;
      droppedXP = 5;

		super.setName("Skeleton");

	}//close Skeleton
   
}//close Skeleton