public class Druid extends GoodGuy 
{

	public Druid()
   {     
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Druid", 50, 1, 12, 0.7D, 12);
   
      //adds this character's special attack
      Attack attack = new StealLife();
      
      attacksInventory.addAttack(attack);
      
	}//close Druid
   
   public void addSecondSpecial()
   {
      Attack attack = new SummonWolf();
      
      attacksInventory.addAttack(attack);
   }
}//close Druid