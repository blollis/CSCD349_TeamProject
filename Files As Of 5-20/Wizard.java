public class Wizard extends GoodGuy 
{

	public Wizard()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Wizard");

	}//close Wizard
}//close Wizard