public class Warrior extends GoodGuy 
{

	public Warrior()
   {
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Warrior", 75, 1, 20, 0.8D, 18);
      
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