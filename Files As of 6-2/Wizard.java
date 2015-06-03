public class Wizard extends GoodGuy 
{

	public Wizard()
   {
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Wizard", 40, 1, 20, 0.8D, 15);

      //adds this character's special attack
      Attack attack = new Fireball();
      
      attacksInventory.addAttack(attack);
      
	}//close Paladin
   
   public void addSecondSpecial()
   {
      Attack attack = new AvadaKedavra();
      
      attacksInventory.addAttack(attack);
   }
   
}//close Wizard