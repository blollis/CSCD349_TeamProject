public class Paladin extends GoodGuy 
{

	public Paladin()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Paladin");

	}//close Paladin
}//close Paladin