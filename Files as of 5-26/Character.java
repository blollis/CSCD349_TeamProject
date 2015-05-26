public abstract class Character 
{
   protected String name;
	protected int HPMax;
   protected int HP;
	protected int damageMin;
	protected int damageMax;
	protected double hitChance;
   protected int speed;
   protected Attacks attacksInventory = new Attacks();

	public Character() 
   {
		//DVC
		name = "";
		HPMax = 0;
      HP = HPMax;
		damageMin = 0;
		damageMax = 0;
		hitChance = 0D;
      speed = 0;
      
      //sets default attack (same for all characters)
      Attack defaultAttack = new DefaultAttack();
      
      attacksInventory.addAttack(defaultAttack);

	}//close DungeonCharacter
   
	public void setName(String nameInput) 
   {
		name = nameInput;
	}//close setName

	public String getName() 
   {
		return name;
	}//close getName

	public void setHP(int HPInput) 
   {
		if (HPInput < 0) 
      {
			HP = 0;
		}
		else 
      {
			HP = HPInput;
		}   
	}//close setHP    

	public int getHP() 
   {
		return HP;
	}//close getHP
   
   public void setHPMax(int HPInput) 
   {
   	HPMax = HPInput;
  	}//close setHPMax    

	public int getHPMax() 
   {
		return HPMax;
	}//close getHP


	public void setDamageMin(int damageMinInput) 
   {
		damageMin = damageMinInput;
	}//close setdamageMin    

	public int getDamageMin() 
   {
		return damageMin;
	}//close getdamageMin

	public void setDamageMax(int damageMaxInput) 
   {
		damageMax = damageMaxInput;
	}//close setdamageMax    

	public int getDamageMax() 
   {
		return damageMax;
	}//close getdamageMax

	public void setHitChance(double hitChanceInput) 
   {
		hitChance = hitChanceInput;
	}//close sethitChance    

	public double getHitChance() 
   {
		return hitChance;
	}//close gethitChance
   
   public void setSpeed(int speedInput)
   {
		speed = speedInput;
	}//close setSpeed    

	public int getSpeed() 
   {
		return speed;
	}//close getSpeed
   
   public boolean checkForLife() 
   {
      if (HP > 0) 
      {
         return true;
      }
      
      return false;
   }//close checkForLife 
   
   //prints basic character info (name and HP)
   public String charInfo() 
   {
      return (this.name + ": " + this.getHP() + "HP");
   } 
   
   //all characters attack the same
   public final void attack(Character incomingCharacter, int choiceInput) 
   {
      Attack attackToExecute = attacksInventory.getAttack(choiceInput);
      
      attackToExecute.useAttack(this, incomingCharacter);
   
   }//close attack 
   
   //prints a list of the character's attacks
   public void printAttacks() 
   {
      for(int i = 0; i < attacksInventory.size(); i++) 
      {
         System.out.println((i+1) + ". " + attacksInventory.getAttack(i).getName());
      }
   }

   //determines if attack number that was chosen is in the character's attacksInventory
   public boolean validAttackChoice(int x) 
   {
      if (x >= 0 && x < attacksInventory.size()) {
         return true;
      }
      
      return false;
   }

	
}