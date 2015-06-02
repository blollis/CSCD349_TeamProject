import java.util.*;

public class Attacks {
   //array list holds all of the attacks the character currently has
   private ArrayList<Attack> attacks;
  
	public Attacks() 
   {
      ArrayList<Attack> currentAttacks = new ArrayList<Attack>(); 
      this.attacks = currentAttacks;  
   
	}//close Party
   
   public void addAttack(Attack newAttack) 
   {
      this.attacks.add(newAttack);
   }
   
   public void removeAttack(int oldAttack) 
   {
      this.attacks.remove(oldAttack);
   }
   
   public int size() 
   {
      return attacks.size();
   }   
     
   public Attack getAttack(int i) 
   {
      return attacks.get(i);
   }   
   
}   