public class Warrior extends GoodGuy 
{

	public Warrior()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Warrior");

	}//close Warrior
}//close Warrior