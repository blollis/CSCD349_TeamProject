import java.util.*;
public class HealPotion implements Item
{
   private String itemName;
   
   public HealPotion() 
   {
      itemName = "Healing Potion";
   }
   
   public String getName()
   {
      return itemName;
   }
   
   public void useItem(GoodGuy user) 
   {
      System.out.println(user.getName() + " used a healing potion to gain 20 HP points.\n");
      
      user.setHP(user.getHP() + 20);
   }
      
}  
