public class Archer extends GoodGuy 
{

	public Archer()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Archer");

	}//close Archer
}//close Archer