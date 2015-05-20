public class Necromancer extends GoodGuy 
{

	public Necromancer()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Necromancer");

	}//close Necromancer
}//close Necromancer