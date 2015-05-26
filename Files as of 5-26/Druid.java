public class Druid extends GoodGuy 
{

	public Druid()
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.7;
		damageMin = 1;
		damageMax = 12;
      speed = 12;
      
      super.setName("Druid");
   
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Druid
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
}//close Druid