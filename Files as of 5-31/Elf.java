public class Elf extends GoodGuy 
{

	public Elf()
   {
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Elf", 60, 4, 12, 0.9D, 16);
      
      //adds this character's special attack
      Attack attack = new PoisonAttack();
      
      attacksInventory.addAttack(attack);
      
	}//close Elf
   
   public void addSecondSpecial()
   {
      Attack attack = new BodySlam();
      
      attacksInventory.addAttack(attack);
   }
}//close Elf