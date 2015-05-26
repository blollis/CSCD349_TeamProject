public class Warrior extends GoodGuy 
{

	public Warrior()
   {
		//DVC
		HPMax = 75;
      HP = HPMax;
		hitChance = 0.8;
		damageMin = 1;
		damageMax = 20;
      speed = 18;
      
      super.setName("Warrior");
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Warrior
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
   
}//close Warrior