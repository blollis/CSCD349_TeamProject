public class Cleric extends GoodGuy 
{

	public Cleric()
   {
		//DVC
		HPMax = 90;
      HP = HPMax;
		hitChance = 0.9;
		damageMin = 1;
		damageMax = 10;
      speed = 8;
      
      super.setName("Cleric");
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Cleric
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
}//close Cleric