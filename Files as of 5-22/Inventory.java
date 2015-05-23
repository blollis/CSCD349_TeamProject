import java.util.*;

public class Inventory {
   private ArrayList<Item> items;
  
	public Inventory() 
   {
      ArrayList<Item> currentInventory = new ArrayList<Item>(); 
      this.items = items;  
   
	}//close Party
   
   public void addItem(Item newItem) 
   {
      this.items.add(newItem);
   }
   
   public void removeItem(int oldItem) 
   {
      this.items.remove(oldItem);
   }
   
   public int size() 
   {
      return items.size();
   }   
     
   public Item getItem(int i) 
   {
      return items.get(i);
   }   
}   