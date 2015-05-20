public class Elf extends GoodGuy 
{

	public Elf()
   {
		//DVC
		HPMax = 120;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 60;
		damageMax = 95;
      speed = 10;
      
      super.setName("Elf");

	}//close Elf
}//close Elf