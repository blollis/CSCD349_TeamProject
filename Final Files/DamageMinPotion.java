import java.util.*;
public class DamageMinPotion implements Item
{
   private String itemName;
   
   public DamageMinPotion() 
   {
      itemName = "Min Damage Potion";
   }
   
   public String getName()
   {
      return itemName;
   }
   
   public void useItem(GoodGuy user) 
   {
      System.out.println(user.getName() + " used a min damage potion to increase their minimum damage by 10!\n");
      
      user.setDamageMin(user.getDamageMin() + 10);
   }
      
}  
