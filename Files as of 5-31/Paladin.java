public class Paladin extends GoodGuy 
{

	public Paladin()
   { 
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Paladin", 100, 1, 15, 0.8D, 7);

      //adds this character's special attack
      Attack attack = new ShieldBash();
      
      attacksInventory.addAttack(attack);
      
	}//close Paladin
   
   public void addSecondSpecial()
   {
      Attack attack = new Sacrifice();
      
      attacksInventory.addAttack(attack);
   }
   
}//close Paladin