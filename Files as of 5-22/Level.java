public class Level 
{
   private int level;
   
   public void setLevel(int x) 
   {
      this.level = x;
   }
   
   public int getLevel() 
   {
      return this.level;
   } 
   
   public void updateLevel(GoodGuy character)
   {
      int tempLevel = 99;
      
      if (character.getXP() < 10)
      {
         tempLevel = 1;
      }
      else if (character.getXP() >= 10 && character.getXP() < 25)
      {
         tempLevel = 2;
      }
      else if (character.getXP() >= 25 && character.getXP() < 45)
      {
         tempLevel = 3;
      }
      else if (character.getXP() >= 45 && character.getXP() < 70)
      {
         tempLevel = 4;
      }
      else 
      {
         tempLevel = 5;
      }
      
      if (tempLevel != this.level) 
      {
         System.out.println("Congratulations! " + character.getName() + " leveled up to " + tempLevel + "!");
      }
      
      this.level = tempLevel;
   }

}