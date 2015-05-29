public class Cleric extends GoodGuy 
{

	public Cleric()
   {  
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Cleric", 90, 1, 10, 0.9D, 8);
      
      //adds this character's special attack
      Attack attack = new RouletteHeal();
      
      attacksInventory.addAttack(attack);
      
	}//close Cleric
   
   public void addSecondSpecial()
   {
      Attack attack = new AttackBuff();
      
      attacksInventory.addAttack(attack);
   }
}//close Cleric