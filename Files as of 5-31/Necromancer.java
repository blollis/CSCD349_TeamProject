public class Necromancer extends GoodGuy 
{

	public Necromancer()
   { 
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Necromancer", 50, 1, 10, 0.9D, 10);
      
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