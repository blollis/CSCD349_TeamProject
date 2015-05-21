public class Elf extends GoodGuy 
{

	public Elf()
   {
		//DVC
		HPMax = 60;
      HP = HPMax;
		hitChance = 0.9;
		damageMin = 1;
		damageMax = 12;
      speed = 16;
      
      super.setName("Elf");

	}//close Elf
}//close Elf