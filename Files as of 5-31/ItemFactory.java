public class ItemFactory
{
   public static Item createItem(int itemID)
   {
      Item item; 
      
      if(itemID < 70)
         item = new HealPotion();
         
      else if(itemID <85)
         item = new HealMaxPotion();
         
      else if(itemID < 95)
         item = new DamageMaxPotion();
        
      else
         item = new DamageMinPotion();
    
      return item; 
   }

}