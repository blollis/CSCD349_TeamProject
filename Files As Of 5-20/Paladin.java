public class Paladin extends GoodGuy 
{

	public Paladin()
   {
		//DVC
		HPMax = 100;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 15;
      speed = 7;
      
      super.setName("Paladin");

	}//close Paladin
}//close Paladin