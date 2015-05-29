public class Paladin extends GoodGuy 
{

	public Paladin()
   { 
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Paladin", 100, 1, 15, 0.8D, 7);

      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
      
	}//close Paladin
   
   public void addSecondSpecial()
   {
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);
   }
   
}//close Paladin