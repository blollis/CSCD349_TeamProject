public class Druid extends GoodGuy 
{

	public Druid()
   {     
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Druid", 50, 1, 12, 0.7D, 12);
   
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