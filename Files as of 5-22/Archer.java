public class Archer extends GoodGuy 
{

	public Archer()
   {
		//DVC
		HPMax = 40;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 20;
      speed = 20;
      
      super.setName("Archer");

	}//close Archer
}//close Archer