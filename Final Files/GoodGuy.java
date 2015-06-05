abstract class GoodGuy extends Character 
{
   private int XP;
   protected Level level;
   protected Inventory inventory;

	protected GoodGuy(String name, int HPMax, int damageMin, int damageMax, double hitChance, int speed) 
   {
		super(name, HPMax, damageMin, damageMax, hitChance, speed);
      
      this.XP = 0;
      
      //initialize inventory
      this.inventory  = new Inventory();
      
      //set character level at creation time as zero
      this.level = new Level();
      
      this.level.setLevel(0);
            
	}//close GoodGuy
      
   public void setXP(int x) 
   {
      this.XP = x;
   }
   
   public int getXP() 
   {
      return this.XP;
   }
   
   public void setLevel(int x) 
   {
      this.level.setLevel(x);
   }
   
   public int getLevel() 
   {
      return this.level.getLevel();
   } 
   
   public void updateLevel(GoodGuy character)
   {
      this.level.updateLevel(character);
   }
   
   public void addInventoryItem(Item item) 
   {
      this.inventory.addItem(item);
   }
   
   public Item getInventoryItem(int x) 
   {
      Item item = this.inventory.getItem(x);
      
      this.inventory.removeItem(x);
      
      return item;
   }
   
   public int getInventorySize()
   {
      return this.inventory.size();
   }
   
   //prints a list of the character's current inventory
   public void printInventory() 
   {
      for(int i = 0; i < inventory.size(); i++) 
      {
         System.out.println((i+1) + ". " + inventory.getItem(i).getName());
      }
   }

   //determines if inventory number that was chosen is in the character's currentInventory
   public boolean validInventoryChoice(int x) 
   {
      if (x >= 0 && x < attacksInventory.size()) {
         return true;
      }
      
      return false;
   }
      
   public String charInfo() 
   {
      return (getName() + " - Level " + getLevel() + ": " + this.getHP() + "HP");
   } 
   
   public String printStats() 
   {
      return (getName()+ ": HP " + getHP() + ", Max Damage " + getDamageMax() + ", Hit Chance " + getHitChance());  
   }
   
   abstract void addSecondSpecial();
	   
}//close GoodGuy