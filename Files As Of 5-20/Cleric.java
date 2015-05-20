public class Cleric extends GoodGuy 
{

	public Cleric()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Cleric");

	}//close Cleric
}//close Cleric