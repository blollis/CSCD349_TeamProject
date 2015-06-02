public class Wizard extends GoodGuy 
{

	public Wizard()
   {
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Wizard", 40, 1, 20, 0.8D, 15);

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