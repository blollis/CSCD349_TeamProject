public class ManBearPig extends BadGuy 
{
	
   public ManBearPig() 
   {
		//DVC
		HPMax = 60;
      HP = HPMax;
		hitChance = 0.6;
		damageMin = 1;
		damageMax = 15;
		chanceToHeal = 0.4;
		healMin = 1;
		healMax = 5;
      speed = 8;
      droppedXP = 10;

		super.setName("ManBearPig");
      
      //adds this character's special attack
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close ManBearPig
   
}//close ManBearPig