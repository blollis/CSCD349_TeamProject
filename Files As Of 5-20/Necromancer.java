public class Necromancer extends GoodGuy 
{

	public Necromancer()
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.9;
		damageMin = 1;
		damageMax = 10;
      speed = 10;
      
      super.setName("Necromancer");

	}//close Necromancer
}//close Necromancer