public class Druid extends GoodGuy 
{

	public Druid()
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.7;
		damageMin = 1;
		damageMax = 12;
      speed = 12;
      
      super.setName("Druid");

	}//close Druid
}//close Druid