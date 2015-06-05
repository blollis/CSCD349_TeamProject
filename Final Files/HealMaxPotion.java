import java.util.*;
public class HealMaxPotion implements Item
{
   private String itemName;
   
   public HealMaxPotion() 
   {
      itemName = "Max Healing Potion";
   }
   
   public String getName()
   {
      return itemName;
   }
   
   public void useItem(GoodGuy user) 
   {
      System.out.println(user.getName() + " used a max healing potion to gain back all their HP!\n");
      
      user.setHP(user.getHPMax());
   }
      
}  
