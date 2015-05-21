public class Cleric extends GoodGuy 
{

	public Cleric()
   {
		//DVC
		HPMax = 90;
      HP = HPMax;
		hitChance = 0.9;
		damageMin = 1;
		damageMax = 10;
      speed = 8;
      
      super.setName("Cleric");

	}//close Cleric
}//close Cleric