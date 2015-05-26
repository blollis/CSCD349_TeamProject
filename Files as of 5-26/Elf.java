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
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Elf
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
}//close Elf