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
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Necromancer
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
}//close Necromancer