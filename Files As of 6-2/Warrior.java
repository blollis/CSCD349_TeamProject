public class Warrior extends GoodGuy 
{

	public Warrior()
   {
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Warrior", 75, 1, 20, 0.8D, 18);
      
      //adds this character's special attack
      Attack attack = new DoubleAttack();
      
      attacksInventory.addAttack(attack);
      
	}//close Paladin
   
   public void addSecondSpecial()
   {
      Attack attack = new WhirlWindOfDeath();
      
      attacksInventory.addAttack(attack);
   }
   
}//close Warrior