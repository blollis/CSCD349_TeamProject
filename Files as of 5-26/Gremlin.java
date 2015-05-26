public class Gremlin extends BadGuy 
{
	
   public Gremlin() 
   {
		//DVC
		HPMax = 30;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 10;
		chanceToHeal = 0.3;
		healMin = 1;
		healMax = 5;
      speed = 17;
      droppedXP = 6;

		super.setName("Gremlin");
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Gremlin
   
}//close Gremlin