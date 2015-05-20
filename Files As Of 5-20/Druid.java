public class Druid extends GoodGuy 
{

	public Druid()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Druid");

	}//close Druid
}//close Druid