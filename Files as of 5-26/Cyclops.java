public class Cyclops extends BadGuy 
{
	
   public Cyclops() 
   {
		//DVC
		HPMax = 50;
      HP = HPMax;
		hitChance = 0.4;
		damageMin = 1;
		damageMax = 20;
		chanceToHeal = 0.1;
		healMin = 1;
		healMax = 20;
      speed = 10;
      droppedXP = 8;

		super.setName("Cyclops");
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close Cyclops
   
}//close Cyclops