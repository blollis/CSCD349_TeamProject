import java.util.*;
public class DamageMaxPotion implements Item
{
   private String itemName;
   
   public DamageMaxPotion() 
   {
      itemName = "Max Damage Potion";
   }
   
   public String getName()
   {
      return itemName;
   }
   
   public void useItem(GoodGuy user) 
   {
      System.out.println(user.getName() + " used a max damage potion to increase their maximum damage by 10!\n");
      
      user.setDamageMax(user.getDamageMax() + 10);
   }
      
}  
