public class Archer extends GoodGuy 
{

	public Archer()
   {  
      //GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
      super("Archer", 40, 1, 20, 0.6D, 20);
      
      //adds this character's special attack
      Attack attack = new PerciseHit();
      
      attacksInventory.addAttack(attack);
      
	}//close Archer
   
   public void addSecondSpecial()
   {
      Attack attack = new RapidShot();
      
      attacksInventory.addAttack(attack);
   }
}//close Archer