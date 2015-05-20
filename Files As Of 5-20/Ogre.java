public class Ogre extends BadGuy 
{
	
   public Ogre() 
   {
		//DVC
		HPMax = 80;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 30;
		damageMax = 60;
		chanceToHeal = 0.1;
		healMin = 30;
		healMax = 60;
      speed = 8;
      droppedXP = 8;

		super.setName("Ogre");

	}//close Ogre
   
}//close Ogre