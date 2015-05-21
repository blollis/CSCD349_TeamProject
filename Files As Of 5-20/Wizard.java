public class Wizard extends GoodGuy 
{

	public Wizard()
   {
		//DVC
		HPMax = 40;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 20;
      speed = 15;
      
      super.setName("Wizard");

	}//close Wizard
}//close Wizard