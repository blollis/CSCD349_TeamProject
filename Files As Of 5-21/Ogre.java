public class Ogre extends BadGuy 
{
	
   public Ogre() 
   {
		//DVC
		HPMax = 45;
      HP = HPMax;
		hitChance = 0.7;
		damageMin = 1;
		damageMax = 12;
		chanceToHeal = 0.1;
		healMin = 1;
		healMax = 20;
      speed = 8;
      droppedXP = 9;

		super.setName("Ogre");

	}//close Ogre
   
}//close Ogre