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

      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Wizard
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
   
}//close Wizard