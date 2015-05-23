public class Warrior extends GoodGuy 
{

	public Warrior()
   {
		//DVC
		HPMax = 75;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 20;
      speed = 18;
      
      super.setName("Warrior");

	}//close Warrior
}//close Warrior